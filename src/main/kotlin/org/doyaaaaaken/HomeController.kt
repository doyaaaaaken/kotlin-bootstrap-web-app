package org.doyaaaaaken

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime
import java.util.*

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String, model: Model): String {
        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    @GetMapping("test")
    fun test(model: Model): String {
        //TODO: driverの設定を、設定ファイルに移す
        Database.connect("jdbc:postgresql://localhost:5442/dykn",  org.postgresql.Driver::class.java.name, "dykn")

        transaction {
            Users.insert {
                it[name] = "name ${LocalDateTime.now()}"
            }

            Users.selectAll().forEach {
                println("Result:   ${it[Users.name]}")
            }
        }

        transaction {
            logger.addLogger(StdOutSqlLogger)

            User.new {
                name = UUID.randomUUID().toString().take(30)
            }
            println(User.all().map { it.name }.joinToString(" / "))
        }

        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    object Users: LongIdTable("users") {
        val name = varchar("name", 32)
    }

    class User(id: EntityID<Long>): LongEntity(id) {
        companion object: LongEntityClass<User>(Users)

        var name by Users.name
    }
}

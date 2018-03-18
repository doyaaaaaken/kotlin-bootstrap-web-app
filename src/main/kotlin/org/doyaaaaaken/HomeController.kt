package org.doyaaaaaken

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime

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

        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    object Users: Table("users") {
        val id = long("id").primaryKey().autoIncrement()
        val name = varchar("name", 32)
    }
}

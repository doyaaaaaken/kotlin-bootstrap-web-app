package org.doyaaaaaken.controller

import org.doyaaaaaken.infrastructure.rdb.dao.User
import org.doyaaaaaken.infrastructure.rdb.table.Users
import org.doyaaaaaken.service.DashboardService
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime
import java.util.*
import javax.sql.DataSource

@Controller
@RequestMapping("/")
class HomeController(
        private val dataSource: DataSource,
        private val dashboardService: DashboardService
) {

    @GetMapping("")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String, model: Model): String {
        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    @GetMapping("test")
    fun test(model: Model): String {
        Database.connect(dataSource)

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
}

package org.doyaaaaaken

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String, model: Model): String {
        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    @GetMapping("test")
    fun test(@RequestParam(value = "name", defaultValue = "World") name: String, model: Model): String {
        //TODO: driverの設定を、設定ファイルに移す
        Database.connect("jdbc:postgresql://localhost:5442/dykn",  org.postgresql.Driver::class.java.name)

        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    object Users: Table("users") {
        val id = long("id").primaryKey()
        val name = varchar("name", 32)
    }
}

package org.doyaaaaaken.controller

import org.doyaaaaaken.service.DashboardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/")
class HomeController(
        private val dashboardService: DashboardService
) {

    @GetMapping("")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String, model: Model): String {
        model.addAllAttributes(mapOf("test" to "testValue"))
        return "home/show"
    }

    @GetMapping("test")
    fun test(model: Model): String {
        val testValue = dashboardService.test()
        model.addAllAttributes(mapOf("test" to testValue))
        return "home/show"
    }
}

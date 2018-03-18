package org.doyaaaaaken

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return "home/show"
    }
}

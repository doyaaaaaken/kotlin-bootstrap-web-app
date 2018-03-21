package org.doyaaaaaken.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/error")
class ErrorController {

    @GetMapping("404")
    fun error404(): String {
        return "error/404"
    }

    @GetMapping("500")
    fun error500(): String {
        return "error/500"
    }
}

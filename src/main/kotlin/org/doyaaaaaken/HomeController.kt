package org.doyaaaaaken

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class HomeController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return "Hello ${counter.incrementAndGet()} $name"
    }
}

package org.doyaaaaaken.controller

import org.doyaaaaaken.util.BaseWebTest
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ErrorControllerTest : BaseWebTest() {

    @Test
    fun error404() {
        get("/error/404").andExpect(status().isOk())
    }

    @Test
    fun error500() {
        get("/error/500").andExpect(status().isOk())
    }
}

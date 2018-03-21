package org.doyaaaaaken.controller

import org.doyaaaaaken.util.BaseWebTest
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class HomeControllerTest : BaseWebTest() {

    @Test
    fun index() {
        get("/").andExpect(status().isOk())
    }
}

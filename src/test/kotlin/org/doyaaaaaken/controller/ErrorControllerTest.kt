package org.doyaaaaaken.controller

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ErrorControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun error404() {
        mockMvc.perform(get("/error/404")).andExpect(status().isOk())
    }

    @Test
    fun error500() {
        mockMvc.perform(get("/error/500")).andExpect(status().isOk())
    }
}
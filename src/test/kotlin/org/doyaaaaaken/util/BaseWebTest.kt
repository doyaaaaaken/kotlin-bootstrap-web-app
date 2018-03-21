package org.doyaaaaaken.util

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
abstract class BaseWebTest {
    @Autowired
    protected lateinit var mockMvc: MockMvc

    fun get(path: String): ResultActions {
        val requestBuilder = MockMvcRequestBuilders.get(path)
        return mockMvc.perform(requestBuilder)
    }
}

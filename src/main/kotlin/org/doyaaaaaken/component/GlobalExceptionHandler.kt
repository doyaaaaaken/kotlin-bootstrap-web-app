package org.doyaaaaaken.component

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class GlobalExceptionHandler : HandlerExceptionResolver {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    override fun resolveException(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?): ModelAndView {
        logger.error(ex.toString(), ex)

        return when(response?.status) {
            404 -> ModelAndView("error/404")
            else -> ModelAndView("error/500")
        }
    }
}

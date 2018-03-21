package org.doyaaaaaken.component

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class GlobalExceptionHandler : HandlerExceptionResolver {

    override fun resolveException(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?): ModelAndView {
        return ModelAndView("error/404")
    }
}

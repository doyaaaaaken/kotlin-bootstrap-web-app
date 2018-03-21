package org.doyaaaaaken.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.headers().contentSecurityPolicy(cspString)
        http.exceptionHandling().accessDeniedPage("/errors/403")
        http.csrf()
    }

    private val cspString = buildString {
        val defaultSrc = listOf(
                "'self'"
        ).joinToString(" ")

        append("default-src $defaultSrc;")
    }
}

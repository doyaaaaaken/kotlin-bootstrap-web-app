package org.doyaaaaaken.service

import org.doyaaaaaken.infrastructure.rdb.dao.User
import org.doyaaaaaken.infrastructure.rdb.table.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Transactional
@Service
class DashboardService {

    fun test(): String {
        Users.insert {
            it[name] = "name ${LocalDateTime.now()}"
        }

        Users.selectAll().forEach {
            println("Result:   ${it[Users.name]}")
        }

        User.new {
            name = UUID.randomUUID().toString().take(30)
        }
        return User.all().map { it.name }.joinToString(" / ")
    }
}

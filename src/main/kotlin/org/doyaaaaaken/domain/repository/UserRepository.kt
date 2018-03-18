package org.doyaaaaaken.domain.repository

import org.doyaaaaaken.domain.model.User
import org.doyaaaaaken.infrastructure.rdb.dao.UserDAO
import org.springframework.stereotype.Repository
import java.util.*

interface UserRepository {
    fun insert(): User
    fun selectAll(): List<User>
}

@Repository
class UserRepositoryImpl : UserRepository {
    override fun insert(): User {
        val created = UserDAO.new {
            name = UUID.randomUUID().toString().take(30)
        }
        return User.from(created)
    }

    override fun selectAll(): List<User> {
        return UserDAO.all().map { User.from(it) }
    }
}

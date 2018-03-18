package org.doyaaaaaken.domain.model

import org.doyaaaaaken.infrastructure.rdb.dao.UserDAO

data class User(val id: Long, val name: String) {
    companion object {
        fun from(userDAO: UserDAO): User {
            return User(userDAO.id.value, userDAO.name)
        }
    }
}

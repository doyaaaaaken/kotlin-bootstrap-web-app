package org.doyaaaaaken.service.viewmodel

import org.doyaaaaaken.domain.model.User

data class UserListView(val value: String) {
    companion object {
        fun from(users: List<User>) = UserListView(users.map{ it.name }.joinToString(" / "))
    }
}
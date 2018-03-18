package org.doyaaaaaken.infrastructure.rdb.dao

import org.doyaaaaaken.infrastructure.rdb.table.Users
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass

class User(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<User>(Users)

    var name by Users.name
}

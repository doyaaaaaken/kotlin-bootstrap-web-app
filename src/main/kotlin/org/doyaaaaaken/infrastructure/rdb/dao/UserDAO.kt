package org.doyaaaaaken.infrastructure.rdb.dao

import org.doyaaaaaken.infrastructure.rdb.table.UsersTable
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass

class UserDAO(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserDAO>(UsersTable)

    var name by UsersTable.name
}

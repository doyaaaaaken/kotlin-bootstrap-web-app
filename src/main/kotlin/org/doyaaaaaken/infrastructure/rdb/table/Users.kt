package org.doyaaaaaken.infrastructure.rdb.table

import org.jetbrains.exposed.dao.LongIdTable

object Users : LongIdTable("users") {
    val name = varchar("name", 32)
}

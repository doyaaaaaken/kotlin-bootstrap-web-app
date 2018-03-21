package org.doyaaaaaken.service.viewmodel

import org.doyaaaaaken.domain.model.User
import org.junit.Test
import kotlin.test.assertEquals

class UserListViewTest {

    @Test
    fun from() {
        val expected = UserListView("Kate / Tom")
        val actual = UserListView.from(
                listOf(User(1, "Kate"), User(2, "Tom"))
        )
        assertEquals(expected, actual)
    }
}

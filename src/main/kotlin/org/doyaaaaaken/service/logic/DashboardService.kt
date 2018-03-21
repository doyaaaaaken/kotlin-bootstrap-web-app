package org.doyaaaaaken.service.logic

import org.doyaaaaaken.domain.repository.UserRepository
import org.doyaaaaaken.service.viewmodel.UserListView
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class DashboardService(
        private val userRepository: UserRepository
) {
    fun test(): UserListView {
        userRepository.insert()
        val results = userRepository.selectAll()
        return UserListView.from(results)
    }
}

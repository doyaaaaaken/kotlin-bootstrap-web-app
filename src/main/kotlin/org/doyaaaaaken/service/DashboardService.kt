package org.doyaaaaaken.service

import org.doyaaaaaken.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class DashboardService(
        private val userRepository: UserRepository
) {
    fun test(): String {
        userRepository.insert()
        val results = userRepository.selectAll()
        return results.map{ it.name }.joinToString(" / ")
    }
}

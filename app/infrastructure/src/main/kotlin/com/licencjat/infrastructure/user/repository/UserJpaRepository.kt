package com.licencjat.infrastructure.user.repository

import com.licencjat.infrastructure.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity?
}
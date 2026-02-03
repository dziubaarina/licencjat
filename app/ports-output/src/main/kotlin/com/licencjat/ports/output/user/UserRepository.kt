package com.licencjat.ports.output.user

import com.licencjat.domain.model.User

interface UserRepository {
    fun save(user: User): User
    fun findAll(): List<User>

    fun findById(id: Long): User?
}
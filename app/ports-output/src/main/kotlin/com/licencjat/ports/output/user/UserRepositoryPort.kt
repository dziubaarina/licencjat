package com.licencjat.ports.output.user

interface UserRepositoryPort {
    fun save(user: UserDomain): UserDomain
    fun findAll(): List<UserDomain>
}
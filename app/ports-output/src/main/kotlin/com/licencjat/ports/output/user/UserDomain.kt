package com.licencjat.ports.output.user

data class UserDomain(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val role: String,
    val isActive: Boolean
)
package com.licencjat.ports.input.user.dto

data class UserDto(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String
)

data class CreateUserCommand(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String
)
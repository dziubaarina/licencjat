package com.licencjat.ports.input.user.dto

data class CreateUserCommand(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val role: String
)
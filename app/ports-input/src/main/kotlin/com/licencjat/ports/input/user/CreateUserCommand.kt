package com.licencjat.ports.input.user

data class CreateUserCommand(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String
)
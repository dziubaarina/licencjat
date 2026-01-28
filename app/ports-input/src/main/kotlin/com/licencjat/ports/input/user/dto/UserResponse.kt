package com.licencjat.ports.input.user.dto

data class UserResponse(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String
)
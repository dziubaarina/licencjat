package com.licencjat.ports.input.user.dto

data class UserResponse(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val role: String
)
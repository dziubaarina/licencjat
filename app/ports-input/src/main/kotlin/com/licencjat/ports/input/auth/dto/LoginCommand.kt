package com.licencjat.ports.input.auth.dto

data class LoginCommand(
    val email: String,
    val password: String
)
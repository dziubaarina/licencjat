package com.licencjat.domain.model

data class User(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val role: Role,
    val isActive: Boolean
) {
    init {
        require(email.contains("@")) { "Email musi zawierać znak '@'" }
        require(firstName.isNotBlank()) { "Imię nie może być puste" }
    }
}
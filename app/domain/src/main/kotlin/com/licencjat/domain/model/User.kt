package com.licencjat.domain.model

data class User(
    val id: Long? = null,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val role: UserRole
) {
    init {
        require(email.contains("@")) { "Email musi zawierać znak '@'" }
        require(firstName.isNotBlank()) { "Imię nie może być puste" }
    }
}

enum class UserRole {
    CHOREOGRAPHER,
    DANCER
}
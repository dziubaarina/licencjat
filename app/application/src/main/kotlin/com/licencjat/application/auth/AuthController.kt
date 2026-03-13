package com.licencjat.application.auth

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String, val role: String) // Dodana rola!

@RestController
@RequestMapping("/auth")
class AuthController {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        val role = when (request.email) {
            "admin@test.pl" -> "ADMIN"
            "choreo@test.pl" -> "CHOREOGRAPHER"
            else -> "DANCER"
        }
        return ResponseEntity.ok(LoginResponse(token = "jwt_token_123", role = role))
    }
}
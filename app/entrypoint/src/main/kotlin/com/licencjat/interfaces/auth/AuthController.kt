package com.licencjat.interfaces.auth

import com.licencjat.ports.input.auth.AuthService
import com.licencjat.ports.input.auth.dto.AuthResponse
import com.licencjat.ports.input.auth.dto.LoginCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@RequestBody command: LoginCommand): AuthResponse {
        return authService.login(command)
    }
}
package com.licencjat.ports.input.auth

import com.licencjat.ports.input.auth.dto.AuthResponse
import com.licencjat.ports.input.auth.dto.LoginCommand

interface AuthService {
    fun login(command: LoginCommand): AuthResponse
}
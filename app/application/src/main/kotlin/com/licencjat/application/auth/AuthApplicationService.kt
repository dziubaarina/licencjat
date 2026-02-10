package com.licencjat.application.auth

import com.licencjat.ports.input.auth.AuthService
import com.licencjat.ports.input.auth.dto.AuthResponse
import com.licencjat.ports.input.auth.dto.LoginCommand
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthApplicationService(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
) : AuthService {

    override fun login(command: LoginCommand): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                command.email,
                command.password
            )
        )

        val userDetails = userDetailsService.loadUserByUsername(command.email)

        val token = jwtService.generateToken(userDetails)

        return AuthResponse(token)
    }
}
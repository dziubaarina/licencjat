package com.licencjat.application.auth

import com.licencjat.ports.output.user.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String, val role: String)

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val userDetailsService: org.springframework.security.core.userdetails.UserDetailsService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return try {
            val user = userRepository.findByEmail(request.email)
                ?: return ResponseEntity.status(401).body(LoginResponse("", "INVALID_CREDENTIALS"))

            if (!passwordEncoder.matches(request.password, user.password)) {
                return ResponseEntity.status(401).body(LoginResponse("", "INVALID_CREDENTIALS"))
            }

            val userDetails = userDetailsService.loadUserByUsername(request.email)
            val token = jwtService.generateToken(userDetails)

            ResponseEntity.ok(LoginResponse(token = token, role = user.role.name))

        } catch (e: Exception) {
            // Logujemy po stronie serwera, ale nie ujawniamy szczegółów klientowi
            println("LOGIN ERROR: ${e::class.simpleName}: ${e.message}")
            ResponseEntity.status(500).body(LoginResponse("", "SERVER_ERROR"))
        }
    }

    // Endpoint testowy — tylko dla dev, można usunąć przed produkcją
    @GetMapping("/test")
    fun test() = "działa"

    // USUNIĘTO: /napraw-hasla-wszystkie — krytyczna luka bezpieczeństwa
}
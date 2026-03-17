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
    private val jwtService: com.licencjat.application.auth.JwtService,
    private val userDetailsService: org.springframework.security.core.userdetails.UserDetailsService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return try {
            // 1. Znajdź użytkownika w bazie
            val user = userRepository.findByEmail(request.email)
                ?: return ResponseEntity.status(401).body(LoginResponse("", "USER_NOT_FOUND"))

            // 2. Sprawdź hasło BCrypt bezpośrednio
            if (!passwordEncoder.matches(request.password, user.password)) {
                return ResponseEntity.status(401).body(LoginResponse("", "BAD_PASSWORD"))
            }

            // 3. Wygeneruj JWT
            val userDetails = userDetailsService.loadUserByUsername(request.email)
            val token = jwtService.generateToken(userDetails)

            ResponseEntity.ok(LoginResponse(token = token, role = user.role.name))

        } catch (e: Exception) {
            println("LOGIN ERROR: ${e::class.simpleName}: ${e.message}")
            e.printStackTrace()
            ResponseEntity.status(500).body(LoginResponse("", "ERROR: ${e.message}"))
        }
    }

    @GetMapping("/test")
    fun test() = "działa"

    @GetMapping("/napraw-hasla-wszystkie")
    fun naprawHaslaWszystkie(): String {
        var message = ""

        // 1. Naprawa Tancerza
        val tancerz = userRepository.findByEmail("tancerz@danceapp.pl")
        if (tancerz != null) {
            // Używamy .copy() prosto na modelu domenowym - czysto i zgodnie z architekturą!
            userRepository.save(tancerz.copy(password = passwordEncoder.encode("tancerz123")))
            message += "Tancerz naprawiony! "
        }

        // 2. Naprawa Trenera
        val trener = userRepository.findByEmail("trener@danceapp.pl")
        if (trener != null) {
            userRepository.save(trener.copy(password = passwordEncoder.encode("trener123")))
            message += "Trener naprawiony! "
        }

        // 3. Naprawa Admina
        val admin = userRepository.findByEmail("admin@danceapp.pl")
        if (admin != null) {
            userRepository.save(admin.copy(password = passwordEncoder.encode("admin123")))
            message += "Admin naprawiony! "
        }

        return "SUKCES: $message"
    }
}
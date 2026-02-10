package com.licencjat.infrastructure.security

import com.licencjat.infrastructure.user.repository.UserJpaRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val repository: UserJpaRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userEntity = repository.findByEmail(username)
            ?: throw UsernameNotFoundException("User not found with email: $username")

        return User.builder()
            .username(userEntity.email)
            .password(userEntity.password)
            .roles(userEntity.role)
            .build()
    }
}
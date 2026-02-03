package com.licencjat.application.user.mapper

import com.licencjat.domain.model.Role
import com.licencjat.domain.model.User
import com.licencjat.ports.input.user.CreateUserCommand
import com.licencjat.ports.input.user.UserResponse
import org.springframework.stereotype.Component

@Component
class UserDtoMapper {

    fun toDto(domain: User): UserResponse {
        return UserResponse(
            id = domain.id,
            firstName = domain.firstName,
            lastName = domain.lastName,
            username = domain.username,
            email = domain.email
        )
    }

    fun toDomain(command: CreateUserCommand): User {
        return User(
            id = null,
            firstName = command.firstName,
            lastName = command.lastName,
            username = command.username,
            email = command.email,
            password = command.password,
            role = Role.USER,
            isActive = true
        )
    }
}
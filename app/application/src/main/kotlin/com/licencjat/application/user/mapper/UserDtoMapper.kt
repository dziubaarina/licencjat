package com.licencjat.application.user.mapper

import com.licencjat.domain.model.User
import com.licencjat.domain.model.UserRole
import com.licencjat.ports.input.user.dto.CreateUserCommand
import com.licencjat.ports.input.user.dto.UserResponse
import org.springframework.stereotype.Component

@Component
class UserDtoMapper {

    fun toDto(domain: User): UserResponse {
        return UserResponse(
            id = domain.id,
            firstName = domain.firstName,
            lastName = domain.lastName,
            email = domain.email,
            role = domain.role.name
        )
    }

    fun toDomain(command: CreateUserCommand): User {
        return User(
            id = null,
            firstName = command.firstName,
            lastName = command.lastName,
            email = command.email,
            password = command.password,

            role = UserRole.valueOf(command.role)
        )
    }
}
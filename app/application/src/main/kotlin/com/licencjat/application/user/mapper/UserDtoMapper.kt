package com.licencjat.application.user.mapper

import com.licencjat.ports.input.user.dto.CreateUserCommand
import com.licencjat.ports.input.user.dto.UserDto
import com.licencjat.ports.output.user.UserDomain
import org.springframework.stereotype.Component

@Component
class UserDtoMapper {

    fun toDto(domain: UserDomain): UserDto {
        return UserDto(
            id = domain.id,
            firstName = domain.firstName,
            lastName = domain.lastName,
            username = domain.username,
            email = domain.email
        )
    }

    fun toDomain(command: CreateUserCommand): UserDomain {
        return UserDomain(
            firstName = command.firstName,
            lastName = command.lastName,
            username = command.username,
            email = command.email,
            password = command.password,
            role = "USER",
            isActive = true
        )
    }
}
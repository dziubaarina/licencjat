package com.licencjat.application.user.service

import com.licencjat.application.user.mapper.UserDtoMapper
import com.licencjat.ports.input.user.UserUseCase
import com.licencjat.ports.input.user.dto.CreateUserCommand
import com.licencjat.ports.input.user.dto.UserDto
import com.licencjat.ports.output.user.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepositoryPort: UserRepositoryPort,
    private val userDtoMapper: UserDtoMapper
) : UserUseCase {

    override fun getAllUsers(): List<UserDto> {
        val users = userRepositoryPort.findAll()
        return users.map { userDtoMapper.toDto(it) }
    }

    override fun createUser(command: CreateUserCommand): UserDto {
        val domainUser = userDtoMapper.toDomain(command)
        val savedUser = userRepositoryPort.save(domainUser)
        return userDtoMapper.toDto(savedUser)
    }
}
package com.licencjat.application.user.service

import com.licencjat.application.user.mapper.UserDtoMapper
import com.licencjat.ports.input.user.CreateUserCommand
import com.licencjat.ports.input.user.UserService
import com.licencjat.ports.input.user.dto.UserResponse
import com.licencjat.ports.output.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserApplicationService(
    private val userRepository: UserRepository,
    private val userDtoMapper: UserDtoMapper
) : UserService {

    override fun getAllUsers(): List<UserResponse> {
        val users = userRepository.findAll()
        return users.map { userDtoMapper.toDto(it) }
    }

    override fun createUser(command: CreateUserCommand): UserResponse {
        val domainUser = userDtoMapper.toDomain(command)
        val savedUser = userRepository.save(domainUser)
        return userDtoMapper.toDto(savedUser)
    }
}
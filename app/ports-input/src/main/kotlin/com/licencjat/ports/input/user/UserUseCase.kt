package com.licencjat.ports.input.user

import com.licencjat.ports.input.user.dto.CreateUserCommand
import com.licencjat.ports.input.user.dto.UserDto

interface UserUseCase {
    fun getAllUsers(): List<UserDto>
    fun createUser(command: CreateUserCommand): UserDto
}
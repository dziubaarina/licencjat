package com.licencjat.ports.input.user

import com.licencjat.ports.input.user.dto.UserResponse

interface UserService {
    fun getAllUsers(): List<UserResponse>
    fun createUser(command: CreateUserCommand): UserResponse
}
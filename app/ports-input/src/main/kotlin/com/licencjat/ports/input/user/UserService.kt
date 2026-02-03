package com.licencjat.ports.input.user

import com.licencjat.ports.input.user.UserResponse

interface UserService {
    fun getAllUsers(): List<UserResponse>
    fun createUser(command: CreateUserCommand): UserResponse
}
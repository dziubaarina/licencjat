package com.licencjat.interfaces.user

import com.licencjat.ports.input.user.CreateUserCommand
import com.licencjat.ports.input.user.UserService
import com.licencjat.ports.input.user.dto.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<UserResponse> {
        return userService.getAllUsers()
    }

    @PostMapping
    fun createUser(@RequestBody command: CreateUserCommand): UserResponse {
        return userService.createUser(command)
    }
}
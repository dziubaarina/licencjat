package com.licencjat.interfaces.user

import com.licencjat.ports.input.user.UserUseCase
import com.licencjat.ports.input.user.dto.CreateUserCommand
import com.licencjat.ports.input.user.dto.UserDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userUseCase: UserUseCase
) {

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userUseCase.getAllUsers()
    }

    @PostMapping
    fun createUser(@RequestBody command: CreateUserCommand): UserDto {
        return userUseCase.createUser(command)
    }
}
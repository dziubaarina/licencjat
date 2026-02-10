package com.licencjat.infrastructure.user.mapper

import com.licencjat.domain.model.User
import com.licencjat.domain.model.UserRole
import com.licencjat.infrastructure.user.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserEntityMapper {

    fun toDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            password = entity.password,
            firstName = entity.firstName,
            lastName = entity.lastName,

            role = UserRole.valueOf(entity.role)
        )
    }

    fun toEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            email = domain.email,
            password = domain.password,
            firstName = domain.firstName,
            lastName = domain.lastName,

            role = domain.role.name
        )
    }
}
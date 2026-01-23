package com.licencjat.infrastructure.user.mapper

import com.licencjat.infrastructure.user.entity.UserEntity
import com.licencjat.ports.output.user.UserDomain
import org.springframework.stereotype.Component

@Component
class UserEntityMapper {

    fun toDomain(entity: UserEntity): UserDomain {
        return UserDomain(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            username = entity.username,
            email = entity.email,
            password = entity.password,
            role = entity.role,
            isActive = entity.isActive
        )
    }

    fun toEntity(domain: UserDomain): UserEntity {
        return UserEntity(
            id = domain.id,
            firstName = domain.firstName,
            lastName = domain.lastName,
            username = domain.username,
            email = domain.email,
            password = domain.password,
            role = domain.role,
            isActive = domain.isActive
        )
    }
}
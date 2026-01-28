package com.licencjat.infrastructure.user.adapter

import com.licencjat.domain.model.User
import com.licencjat.infrastructure.user.mapper.UserEntityMapper
import com.licencjat.infrastructure.user.repository.UserJpaRepository
import com.licencjat.ports.output.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserRepositoryAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userEntityMapper: UserEntityMapper
) : UserRepository {

    override fun save(user: User): User {
        val entity = userEntityMapper.toEntity(user)
        val savedEntity = userJpaRepository.save(entity)
        return userEntityMapper.toDomain(savedEntity)
    }

    override fun findAll(): List<User> {
        return userJpaRepository.findAll()
            .map { userEntityMapper.toDomain(it) }
    }
}
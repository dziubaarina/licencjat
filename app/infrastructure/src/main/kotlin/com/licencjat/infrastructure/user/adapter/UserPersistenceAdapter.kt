package com.licencjat.infrastructure.user.adapter

import com.licencjat.infrastructure.user.mapper.UserEntityMapper
import com.licencjat.infrastructure.user.repository.UserJpaRepository
import com.licencjat.ports.output.user.UserDomain
import com.licencjat.ports.output.user.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userEntityMapper: UserEntityMapper
) : UserRepositoryPort {

    override fun save(user: UserDomain): UserDomain {
        val entity = userEntityMapper.toEntity(user)
        val savedEntity = userJpaRepository.save(entity)
        return userEntityMapper.toDomain(savedEntity)
    }

    override fun findAll(): List<UserDomain> {
        return userJpaRepository.findAll()
            .map { userEntityMapper.toDomain(it) }
    }
}
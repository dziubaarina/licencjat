package com.licencjat.infrastructure.task.adapter

import com.licencjat.domain.model.Task
import com.licencjat.infrastructure.task.mapper.TaskEntityMapper
import com.licencjat.infrastructure.task.repository.TaskJpaRepository
import com.licencjat.ports.output.task.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskRepositoryAdapter(
    private val repository: TaskJpaRepository,
    private val mapper: TaskEntityMapper
) : TaskRepository {

    override fun save(task: Task): Task {
        val entity = mapper.toEntity(task)
        val saved = repository.save(entity)
        return mapper.toDomain(saved)
    }

    override fun findAll(): List<Task> {
        return repository.findAll().map { mapper.toDomain(it) }
    }

    override fun findById(id: Long): Task? {
        return repository.findById(id).map { mapper.toDomain(it) }.orElse(null)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }
}
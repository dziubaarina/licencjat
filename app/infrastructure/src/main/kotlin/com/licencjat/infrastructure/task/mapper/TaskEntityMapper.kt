package com.licencjat.infrastructure.task.mapper

import com.licencjat.domain.model.Task
import com.licencjat.infrastructure.task.entity.TaskEntity
import org.springframework.stereotype.Component

@Component
class TaskEntityMapper {

    fun toDomain(entity: TaskEntity): Task {
        return Task(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            deadline = entity.deadline,
            instructionVideoUrl = entity.instructionVideoUrl,
            choreographerId = entity.choreographerId
        )
    }

    fun toEntity(domain: Task): TaskEntity {
        return TaskEntity(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            deadline = domain.deadline,
            instructionVideoUrl = domain.instructionVideoUrl,
            choreographerId = domain.choreographerId
        )
    }
}
package com.licencjat.application.task.mapper

import com.licencjat.domain.model.Task
import com.licencjat.ports.input.task.dto.TaskResponse
import org.springframework.stereotype.Component

@Component
class TaskDtoMapper {

    fun toDto(domain: Task): TaskResponse {
        return TaskResponse(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            deadline = domain.deadline,
            instructionVideoUrl = domain.instructionVideoUrl,
            choreographerId = domain.choreographerId
        )
    }

}
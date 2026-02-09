package com.licencjat.application.task.service

import com.licencjat.application.task.mapper.TaskDtoMapper
import com.licencjat.domain.model.Task
import com.licencjat.ports.input.task.TaskService
import com.licencjat.ports.input.task.dto.CreateTaskCommand
import com.licencjat.ports.input.task.dto.TaskResponse
import com.licencjat.ports.output.file.FileStoragePort
import com.licencjat.ports.output.task.TaskRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional // <--- Tylko ten import!

@Service
class TaskApplicationService(
    private val repository: TaskRepository,
    private val mapper: TaskDtoMapper,
    private val fileStoragePort: FileStoragePort
) : TaskService {

    @Transactional
    override fun createTask(command: CreateTaskCommand): TaskResponse {
        // 1. Zapisz plik fizycznie na dysku
        val savedFilePath = fileStoragePort.save(command.file)

        // 2. Stwórz obiekt Domeny ręcznie
        val domain = Task(
            title = command.title,
            description = command.description,
            deadline = command.deadline,
            instructionVideoUrl = savedFilePath,
            choreographerId = command.choreographerId
        )

        val saved = repository.save(domain)
        return mapper.toDto(saved)
    }

    override fun getAllTasks(): List<TaskResponse> {
        return repository.findAll().map { mapper.toDto(it) }
    }

    override fun getTask(id: Long): TaskResponse {
        val task = repository.findById(id) ?: throw RuntimeException("Task not found")
        return mapper.toDto(task)
    }

    @Transactional
    override fun deleteTask(id: Long) {
        repository.deleteById(id)
    }
}
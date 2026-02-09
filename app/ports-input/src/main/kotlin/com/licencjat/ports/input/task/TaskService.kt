package com.licencjat.ports.input.task

import com.licencjat.ports.input.task.dto.CreateTaskCommand
import com.licencjat.ports.input.task.dto.TaskResponse

interface TaskService {
    fun createTask(command: CreateTaskCommand): TaskResponse
    fun getAllTasks(): List<TaskResponse>
    fun getTask(id: Long): TaskResponse
    fun deleteTask(id: Long)
}
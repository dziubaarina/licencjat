package com.licencjat.ports.output.task

import com.licencjat.domain.model.Task

interface TaskRepository {
    fun save(task: Task): Task
    fun findAll(): List<Task>
    fun findById(id: Long): Task?
    fun deleteById(id: Long)
}
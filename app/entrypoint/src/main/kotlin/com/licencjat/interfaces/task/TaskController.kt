package com.licencjat.interfaces.task

import com.licencjat.ports.input.task.TaskService
import com.licencjat.ports.input.task.dto.CreateTaskCommand
import com.licencjat.ports.input.task.dto.TaskResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService
) {

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createTask(
        @RequestParam("title") title: String,
        @RequestParam("description") description: String,
        @RequestParam("deadline") deadline: String, //np. "01.01.2026 15:00"
        @RequestParam("choreographerId") choreographerId: Long,
        @RequestParam("file") file: MultipartFile
    ): TaskResponse {

        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")

        val command = CreateTaskCommand(
            title = title,
            description = description,
            deadline = LocalDateTime.parse(deadline, formatter),
            file = file,
            choreographerId = choreographerId
        )

        return taskService.createTask(command)
    }

    @GetMapping
    fun getAllTasks(): List<TaskResponse> {
        return taskService.getAllTasks()
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): TaskResponse {
        return taskService.getTask(id)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        taskService.deleteTask(id)
    }
}
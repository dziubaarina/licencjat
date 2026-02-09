package com.licencjat.interfaces.task

import com.licencjat.ports.input.task.TaskService
import com.licencjat.ports.input.task.dto.CreateTaskCommand
import com.licencjat.ports.input.task.dto.TaskResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService
) {


    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createTask(
        @RequestParam("title") title: String,
        @RequestParam("description") description: String,
        @RequestParam("deadline") deadline: String,
        @RequestParam("choreographerId") choreographerId: Long,
        @RequestParam("file") file: MultipartFile
    ): TaskResponse {

        val command = CreateTaskCommand(
            title = title,
            description = description,
            deadline = LocalDateTime.parse(deadline),
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
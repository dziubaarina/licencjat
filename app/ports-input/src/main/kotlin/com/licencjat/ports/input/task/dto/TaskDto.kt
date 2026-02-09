package com.licencjat.ports.input.task.dto

import java.time.LocalDateTime
import org.springframework.web.multipart.MultipartFile

data class TaskResponse(
    val id: Long?,
    val title: String,
    val description: String,
    val deadline: LocalDateTime,
    val instructionVideoUrl: String?,
    val choreographerId: Long
)

data class CreateTaskCommand(
    val title: String,
    val description: String,
    val deadline: LocalDateTime,
    val file: MultipartFile,
    val choreographerId: Long
)
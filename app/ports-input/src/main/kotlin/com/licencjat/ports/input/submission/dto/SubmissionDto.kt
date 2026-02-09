package com.licencjat.ports.input.submission.dto

import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

data class SubmissionResponse(
    val id: Long?,
    val taskId: Long,
    val dancerId: Long,
    val videoUrl: String,
    val sentAt: LocalDateTime,
    val status: String,
    val score: Int?,
    val feedback: String?
)

data class CreateSubmissionCommand(
    val taskId: Long,
    val dancerId: Long,
    val file: MultipartFile
)

data class GradeSubmissionCommand(
    val submissionId: Long,
    val score: Int,
    val feedback: String?
)
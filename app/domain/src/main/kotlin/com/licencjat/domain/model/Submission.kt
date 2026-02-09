package com.licencjat.domain.model

import java.time.LocalDateTime

data class Submission(
    val id: Long? = null,
    val taskId: Long,
    val dancerId: Long,
    val videoUrl: String,
    val sentAt: LocalDateTime,
    val status: String,
    val score: Int? = null,
    val feedback: String? = null
)
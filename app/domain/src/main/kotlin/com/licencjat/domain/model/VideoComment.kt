package com.licencjat.domain.model

import java.time.LocalDateTime

data class VideoComment(
    val id: Long? = null,
    val submissionId: Long,
    val authorId: Long,
    val timestampSeconds: Long, // Np. 28 (sekunda)
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
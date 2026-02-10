package com.licencjat.ports.input.comment.dto

import java.time.LocalDateTime

// To co wysyła Frontend (Choreograf klika "Wyślij")
data class AddCommentCommand(
    val submissionId: Long,
    val authorId: Long,
    val timestampSeconds: Long, // Frontend wyśle: 28
    val content: String
)

// To co odsyłamy do wyświetlenia listy
data class CommentResponse(
    val id: Long?,
    val authorId: Long,
    val timestampSeconds: Long,
    val formattedTime: String, // Np. "00:28"
    val content: String,
    val createdAt: LocalDateTime
)
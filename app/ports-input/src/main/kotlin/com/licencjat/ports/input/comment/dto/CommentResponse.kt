package com.licencjat.ports.input.comment.dto

import java.time.LocalDateTime

data class AddCommentCommand(
    val submissionId: Long,
    val authorId: Long,
    val timestampSeconds: Long,
    val content: String
)

data class CommentResponse(
    val id: Long?,
    val submissionId: Long,
    val authorId: Long,
    val timestampSeconds: Long,
    val formattedTime: String,
    val content: String,
    val createdAt: LocalDateTime
)
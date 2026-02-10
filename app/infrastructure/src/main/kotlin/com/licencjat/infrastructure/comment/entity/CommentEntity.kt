package com.licencjat.infrastructure.comment.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "video_comments")
class CommentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "submission_id")
    val submissionId: Long,

    @Column(name = "author_id")
    val authorId: Long,

    @Column(name = "timestamp_seconds")
    val timestampSeconds: Long,

    val content: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime
)
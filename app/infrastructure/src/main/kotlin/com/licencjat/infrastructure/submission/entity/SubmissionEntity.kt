package com.licencjat.infrastructure.submission.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "submissions")
class SubmissionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "task_id", nullable = false)
    val taskId: Long,

    @Column(name = "dancer_id", nullable = false)
    val dancerId: Long,

    @Column(name = "video_url", nullable = false)
    val videoUrl: String,

    @Column(name = "sent_at", nullable = false)
    val sentAt: LocalDateTime,

    @Column(nullable = false)
    val status: String,

    @Column(nullable = true)
    val score: Int?,

    @Column(nullable = true, length = 2000)
    val feedback: String?
)
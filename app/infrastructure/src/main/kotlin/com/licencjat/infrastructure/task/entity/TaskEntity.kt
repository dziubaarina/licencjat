package com.licencjat.infrastructure.task.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
class TaskEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, length = 2000)
    val description: String,

    @Column(nullable = false)
    val deadline: LocalDateTime,

    @Column(name = "instruction_video_url")
    val instructionVideoUrl: String?,

    @Column(name = "choreographer_id", nullable = false)
    val choreographerId: Long
)
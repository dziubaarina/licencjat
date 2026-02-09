package com.licencjat.domain.model

import java.time.LocalDateTime

data class Task(
    val id: Long? = null,
    val title: String,
    val description: String,
    val deadline: LocalDateTime,
    val instructionVideoUrl: String?,
    val choreographerId: Long
)
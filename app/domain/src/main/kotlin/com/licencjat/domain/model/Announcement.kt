package com.licencjat.domain.model

import java.time.LocalDateTime

data class Announcement(
    val id: Long? = null,
    val title: String,
    val description: String,
    val date: LocalDateTime,
    val type: String,
    val link: String?,
    val authorId: Long
)
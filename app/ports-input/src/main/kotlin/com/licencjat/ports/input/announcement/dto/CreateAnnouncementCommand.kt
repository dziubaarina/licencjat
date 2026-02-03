package com.licencjat.ports.input.announcement.dto

import java.time.LocalDateTime

data class CreateAnnouncementCommand(
    val title: String,
    val description: String,
    val date: LocalDateTime,
    val type: String,
    val link: String?,
    val authorId: Long
)
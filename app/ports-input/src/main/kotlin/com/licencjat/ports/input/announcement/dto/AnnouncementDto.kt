package com.licencjat.ports.input.announcement.dto

import java.time.LocalDateTime

data class AnnouncementResponse(
    val id: Long?,
    val title: String,
    val description: String,
    val date: LocalDateTime,
    val type: String,
    val link: String?,
    val authorId: Long
)

data class CreateAnnouncementCommand(
    val title: String,
    val description: String,
    val date: LocalDateTime,
    val type: String,
    val link: String?,
    val authorId: Long
)

data class UpdateAnnouncementCommand(
    val id: Long,
    val title: String,
    val description: String,
    val date: LocalDateTime,
    val type: String,
    val link: String?
)
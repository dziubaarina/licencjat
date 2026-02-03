package com.licencjat.infrastructure.announcement.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "announcements")
class AnnouncementEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, length = 2000)
    val description: String,

    @Column(nullable = false)
    val date: LocalDateTime,

    @Column(nullable = false)
    val type: String,

    @Column
    val link: String?,

    @Column(name = "author_id", nullable = false)
    val authorId: Long
)
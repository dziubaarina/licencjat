package com.licencjat.ports.output.announcement

import com.licencjat.domain.model.Announcement

interface AnnouncementRepository {
    fun save(announcement: Announcement): Announcement
    fun findAll(): List<Announcement>
    fun findById(id: Long): Announcement?
    fun deleteById(id: Long)
}
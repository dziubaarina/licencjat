package com.licencjat.ports.input.announcement

import com.licencjat.ports.input.announcement.dto.*

interface AnnouncementService {
    fun getAllAnnouncements(): List<AnnouncementResponse>
    fun createAnnouncement(command: CreateAnnouncementCommand): AnnouncementResponse
    fun updateAnnouncement(command: UpdateAnnouncementCommand): AnnouncementResponse
    fun deleteAnnouncement(id: Long)
}
package com.licencjat.application.announcement.mapper

import com.licencjat.domain.model.Announcement
import com.licencjat.ports.input.announcement.dto.AnnouncementResponse
import com.licencjat.ports.input.announcement.dto.CreateAnnouncementCommand
import org.springframework.stereotype.Component

@Component
class AnnouncementDtoMapper {

    fun toDto(domain: Announcement): AnnouncementResponse {
        return AnnouncementResponse(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            date = domain.date,
            type = domain.type,
            link = domain.link,
            authorId = domain.authorId
        )
    }

    fun toDomain(command: CreateAnnouncementCommand): Announcement {
        return Announcement(
            title = command.title,
            description = command.description,
            date = command.date,
            type = command.type,
            link = command.link,
            authorId = command.authorId
        )
    }
}
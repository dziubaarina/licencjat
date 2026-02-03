package com.licencjat.infrastructure.announcement.mapper

import com.licencjat.domain.model.Announcement
import com.licencjat.infrastructure.announcement.entity.AnnouncementEntity
import org.springframework.stereotype.Component

@Component
class AnnouncementEntityMapper {

    fun toDomain(entity: AnnouncementEntity): Announcement {
        return Announcement(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            date = entity.date,
            type = entity.type,
            link = entity.link,
            authorId = entity.authorId
        )
    }

    fun toEntity(domain: Announcement): AnnouncementEntity {
        return AnnouncementEntity(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            date = domain.date,
            type = domain.type,
            link = domain.link,
            authorId = domain.authorId
        )
    }
}
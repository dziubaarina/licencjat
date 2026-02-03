package com.licencjat.application.announcement.service

import com.licencjat.application.announcement.mapper.AnnouncementDtoMapper
import com.licencjat.ports.input.announcement.AnnouncementService
import com.licencjat.ports.input.announcement.dto.*
import com.licencjat.ports.output.announcement.AnnouncementRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementApplicationService(
    private val repository: AnnouncementRepository,
    private val mapper: AnnouncementDtoMapper
) : AnnouncementService {

    override fun getAllAnnouncements(): List<AnnouncementResponse> {
        return repository.findAll().map { mapper.toDto(it) }
    }

    override fun createAnnouncement(command: CreateAnnouncementCommand): AnnouncementResponse {
        val domain = mapper.toDomain(command)
        val saved = repository.save(domain)
        return mapper.toDto(saved)
    }

    override fun updateAnnouncement(command: UpdateAnnouncementCommand): AnnouncementResponse {
        val existing = repository.findById(command.id) ?: throw RuntimeException("Not found")

        // Kopiujemy obiekt z nowymi danymi
        val updated = existing.copy(
            title = command.title,
            description = command.description,
            date = command.date,
            type = command.type,
            link = command.link
        )

        val saved = repository.save(updated)
        return mapper.toDto(saved)
    }

    override fun deleteAnnouncement(id: Long) {
        repository.deleteById(id)
    }
}
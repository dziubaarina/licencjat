package com.licencjat.infrastructure.announcement.adapter

import com.licencjat.domain.model.Announcement
import com.licencjat.infrastructure.announcement.mapper.AnnouncementEntityMapper
import com.licencjat.infrastructure.announcement.repository.AnnouncementJpaRepository
import com.licencjat.ports.output.announcement.AnnouncementRepository
import org.springframework.stereotype.Service

@Service
class AnnouncementRepositoryAdapter(
    private val repository: AnnouncementJpaRepository,
    private val mapper: AnnouncementEntityMapper
) : AnnouncementRepository {

    override fun save(announcement: Announcement): Announcement {
        val entity = mapper.toEntity(announcement)
        val savedEntity = repository.save(entity)
        return mapper.toDomain(savedEntity)
    }

    override fun findAll(): List<Announcement> {
        return repository.findAll().map { mapper.toDomain(it) }
    }

    override fun findById(id: Long): Announcement? {
        return repository.findById(id).map { mapper.toDomain(it) }.orElse(null)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }
}
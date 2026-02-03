package com.licencjat.infrastructure.announcement.repository

import com.licencjat.infrastructure.announcement.entity.AnnouncementEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnnouncementJpaRepository : JpaRepository<AnnouncementEntity, Long>
package com.licencjat.infrastructure.submission.repository

import com.licencjat.infrastructure.submission.entity.SubmissionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubmissionJpaRepository : JpaRepository<SubmissionEntity, Long> {
    fun findAllByTaskId(taskId: Long): List<SubmissionEntity>
    fun findAllByDancerId(dancerId: Long): List<SubmissionEntity>
}
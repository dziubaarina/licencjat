package com.licencjat.infrastructure.comment.repository

import com.licencjat.infrastructure.comment.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentJpaRepository : JpaRepository<CommentEntity, Long> {
    fun findAllBySubmissionIdOrderByTimestampSecondsAsc(submissionId: Long): List<CommentEntity>
}
package com.licencjat.infrastructure.comment.repository

import com.licencjat.infrastructure.comment.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentJpaRepository : JpaRepository<CommentEntity, Long> {
    // Ta linia naprawi błąd "Unresolved reference" w Adapterze:
    fun findAllBySubmissionId(submissionId: Long): List<CommentEntity>
}
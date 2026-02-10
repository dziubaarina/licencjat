package com.licencjat.infrastructure.comment.adapter

import com.licencjat.domain.model.VideoComment
import com.licencjat.infrastructure.comment.entity.CommentEntity
import com.licencjat.infrastructure.comment.repository.CommentJpaRepository
import com.licencjat.ports.output.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentRepositoryAdapter(
    private val jpaRepository: CommentJpaRepository
) : CommentRepository {

    override fun save(comment: VideoComment): VideoComment {
        val entity = CommentEntity(
            id = comment.id,
            submissionId = comment.submissionId,
            authorId = comment.authorId,
            timestampSeconds = comment.timestampSeconds,
            content = comment.content,
            createdAt = comment.createdAt
        )
        val saved = jpaRepository.save(entity)
        return comment.copy(id = saved.id)
    }

    override fun findAllBySubmissionId(submissionId: Long): List<VideoComment> {
        return jpaRepository.findAllBySubmissionIdOrderByTimestampSecondsAsc(submissionId).map {
            VideoComment(
                id = it.id,
                submissionId = it.submissionId,
                authorId = it.authorId,
                timestampSeconds = it.timestampSeconds,
                content = it.content,
                createdAt = it.createdAt
            )
        }
    }
}
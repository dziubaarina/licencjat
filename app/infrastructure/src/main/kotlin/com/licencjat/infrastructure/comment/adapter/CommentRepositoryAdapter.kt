package com.licencjat.infrastructure.comment.adapter

import com.licencjat.domain.model.VideoComment
import com.licencjat.infrastructure.comment.mapper.CommentEntityMapper
import com.licencjat.infrastructure.comment.repository.CommentJpaRepository
import com.licencjat.ports.output.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentRepositoryAdapter(
    private val jpaRepository: CommentJpaRepository,
    private val mapper: CommentEntityMapper
) : CommentRepository {

    override fun save(comment: VideoComment): VideoComment {
        val entity = mapper.toEntity(comment)
        val savedEntity = jpaRepository.save(entity)
        return mapper.toDomain(savedEntity)
    }

    override fun findAllBySubmissionId(submissionId: Long): List<VideoComment> {
        return jpaRepository.findAllBySubmissionId(submissionId)
            .map { mapper.toDomain(it) }
    }

    override fun deleteById(id: Long) {
        jpaRepository.deleteById(id)
    }
}
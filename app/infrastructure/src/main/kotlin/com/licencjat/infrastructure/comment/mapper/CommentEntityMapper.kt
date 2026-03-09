package com.licencjat.infrastructure.comment.mapper

import com.licencjat.domain.model.VideoComment
import com.licencjat.infrastructure.comment.entity.CommentEntity
import org.springframework.stereotype.Component

@Component
class CommentEntityMapper {

    fun toEntity(domain: VideoComment): CommentEntity {
        return CommentEntity(
            id = domain.id,
            submissionId = domain.submissionId,
            authorId = domain.authorId,
            timestampSeconds = domain.timestampSeconds,
            content = domain.content,
            createdAt = domain.createdAt
        )
    }

    fun toDomain(entity: CommentEntity): VideoComment {
        return VideoComment(
            id = entity.id,
            submissionId = entity.submissionId,
            authorId = entity.authorId,
            content = entity.content,
            timestampSeconds = entity.timestampSeconds,
            createdAt = entity.createdAt
        )
    }
}
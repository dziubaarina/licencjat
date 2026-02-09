package com.licencjat.infrastructure.submission.mapper

import com.licencjat.domain.model.Submission
import com.licencjat.infrastructure.submission.entity.SubmissionEntity
import org.springframework.stereotype.Component

@Component
class SubmissionEntityMapper {

    fun toDomain(entity: SubmissionEntity): Submission {
        return Submission(
            id = entity.id,
            taskId = entity.taskId,
            dancerId = entity.dancerId,
            videoUrl = entity.videoUrl,
            sentAt = entity.sentAt,
            status = entity.status,
            score = entity.score,
            feedback = entity.feedback
        )
    }

    fun toEntity(domain: Submission): SubmissionEntity {
        return SubmissionEntity(
            id = domain.id,
            taskId = domain.taskId,
            dancerId = domain.dancerId,
            videoUrl = domain.videoUrl,
            sentAt = domain.sentAt,
            status = domain.status,
            score = domain.score,
            feedback = domain.feedback
        )
    }
}
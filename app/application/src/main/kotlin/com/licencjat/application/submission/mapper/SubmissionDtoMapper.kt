package com.licencjat.application.submission.mapper

import com.licencjat.domain.model.Submission
import com.licencjat.ports.input.submission.dto.SubmissionResponse
import org.springframework.stereotype.Component

@Component
class SubmissionDtoMapper {

    fun toDto(domain: Submission): SubmissionResponse {
        return SubmissionResponse(
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
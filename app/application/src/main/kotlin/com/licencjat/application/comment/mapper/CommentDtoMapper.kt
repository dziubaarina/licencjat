package com.licencjat.application.comment.mapper

import com.licencjat.domain.model.VideoComment
import com.licencjat.ports.input.comment.dto.CommentResponse
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CommentDtoMapper {

    fun toDto(domain: VideoComment): CommentResponse {
        return CommentResponse(
            id = domain.id,
            submissionId = domain.submissionId,
            authorId = domain.authorId,
            timestampSeconds = domain.timestampSeconds.toLong(),
            formattedTime = formatSeconds(domain.timestampSeconds.toLong()),
            content = domain.content,
            createdAt = LocalDateTime.now()
        )
    }

    private fun formatSeconds(totalSeconds: Long): String {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return "%02d:%02d".format(minutes, seconds)
    }
}
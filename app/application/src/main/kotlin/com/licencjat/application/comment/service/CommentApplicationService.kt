package com.licencjat.application.comment.service

import com.licencjat.domain.model.VideoComment
import com.licencjat.ports.input.comment.CommentService
import com.licencjat.ports.input.comment.dto.AddCommentCommand
import com.licencjat.ports.input.comment.dto.CommentResponse
import com.licencjat.ports.output.comment.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentApplicationService(
    private val repository: CommentRepository
) : CommentService {

    @Transactional
    override fun addComment(command: AddCommentCommand): CommentResponse {
        val domain = VideoComment(
            submissionId = command.submissionId,
            authorId = command.authorId,
            timestampSeconds = command.timestampSeconds,
            content = command.content
        )
        val saved = repository.save(domain)
        return toResponse(saved)
    }

    override fun getCommentsForSubmission(submissionId: Long): List<CommentResponse> {
        return repository.findAllBySubmissionId(submissionId).map { toResponse(it) }
    }

    //format MM:SS
    private fun toResponse(domain: VideoComment): CommentResponse {
        val minutes = domain.timestampSeconds / 60
        val seconds = domain.timestampSeconds % 60
        val formatted = String.format("%02d:%02d", minutes, seconds)

        return CommentResponse(
            id = domain.id,
            authorId = domain.authorId,
            timestampSeconds = domain.timestampSeconds,
            formattedTime = formatted, // Tu wysyłamy np. "01:05"
            content = domain.content,
            createdAt = domain.createdAt
        )
    }
}
package com.licencjat.application.comment.service

import com.licencjat.application.comment.mapper.CommentDtoMapper
import com.licencjat.domain.model.VideoComment
import com.licencjat.ports.input.comment.CommentService
import com.licencjat.ports.input.comment.dto.AddCommentCommand
import com.licencjat.ports.input.comment.dto.CommentResponse
import com.licencjat.ports.output.comment.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentApplicationService(
    private val repository: CommentRepository,
    private val mapper: CommentDtoMapper
) : CommentService {

    @Transactional
    override fun addComment(command: AddCommentCommand): CommentResponse {
        val domain = VideoComment(
            submissionId = command.submissionId,
            authorId = command.authorId,
            content = command.content,
            timestampSeconds = command.timestampSeconds
        )
        val saved = repository.save(domain)
        return mapper.toDto(saved)
    }

    override fun getCommentsForSubmission(submissionId: Long): List<CommentResponse> {
        return repository.findAllBySubmissionId(submissionId).map { mapper.toDto(it) }
    }

    @Transactional
    override fun deleteComment(id: Long) {
        repository.deleteById(id)
    }
}
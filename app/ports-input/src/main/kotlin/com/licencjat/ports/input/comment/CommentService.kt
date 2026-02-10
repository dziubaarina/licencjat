package com.licencjat.ports.input.comment

import com.licencjat.ports.input.comment.dto.AddCommentCommand
import com.licencjat.ports.input.comment.dto.CommentResponse

interface CommentService {
    fun addComment(command: AddCommentCommand): CommentResponse
    fun getCommentsForSubmission(submissionId: Long): List<CommentResponse>
}
package com.licencjat.interfaces.comment

import com.licencjat.ports.input.comment.CommentService
import com.licencjat.ports.input.comment.dto.AddCommentCommand
import com.licencjat.ports.input.comment.dto.CommentResponse
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(
    private val commentService: CommentService
) {

    @PreAuthorize("hasAnyAuthority('CHOREOGRAPHER', 'ADMIN')")
    @PostMapping
    fun addComment(@RequestBody command: AddCommentCommand): CommentResponse {
        return commentService.addComment(command)
    }

    @GetMapping("/submission/{submissionId}")
    fun getComments(@PathVariable submissionId: Long): List<CommentResponse> {
        return commentService.getCommentsForSubmission(submissionId)
    }

    @PreAuthorize("hasAnyAuthority('CHOREOGRAPHER', 'ADMIN')")
    @DeleteMapping("/{id}")
    fun deleteComment(@PathVariable id: Long) {
        commentService.deleteComment(id)
    }
}
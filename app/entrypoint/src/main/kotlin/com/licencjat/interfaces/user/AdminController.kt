package com.licencjat.interfaces.user

import com.licencjat.ports.input.user.dto.UserResponse
import com.licencjat.ports.input.user.UserService
import com.licencjat.ports.input.submission.SubmissionService
import com.licencjat.ports.input.comment.CommentService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
class AdminController(
    private val userService: UserService,
    private val submissionService: SubmissionService,
    private val commentService: CommentService
) {

    @GetMapping("/users")
    fun getAllUsers(): List<UserResponse> = userService.getAllUsers()

    @PatchMapping("/users/{id}/status")
    fun changeUserStatus(@PathVariable id: Long, @RequestParam active: Boolean) {
        userService.setUserStatus(id, active)
    }

    @DeleteMapping("/submissions/{id}")
    fun moderateSubmission(@PathVariable id: Long) = submissionService.deleteSubmission(id)

    @DeleteMapping("/comments/{id}")
    fun moderateComment(@PathVariable id: Long) = commentService.deleteComment(id)

    @GetMapping("/stats")
    fun getStats(): Map<String, Any> {
        val allUsers = userService.getAllUsers()
        return mapOf(
            "activeUsersCount" to allUsers.count { it.isActive },
            "totalVideosCount" to submissionService.getTotalSubmissionsCount()
        )
    }
}
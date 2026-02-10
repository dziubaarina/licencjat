package com.licencjat.ports.output.comment

import com.licencjat.domain.model.VideoComment

interface CommentRepository {
    fun save(comment: VideoComment): VideoComment
    fun findAllBySubmissionId(submissionId: Long): List<VideoComment>
}
package com.licencjat.ports.output.submission

import com.licencjat.domain.model.Submission

interface SubmissionRepository {
    fun save(submission: Submission): Submission
    fun findById(id: Long): Submission?
    fun findAllByTaskId(taskId: Long): List<Submission>
    fun findAllByDancerId(dancerId: Long): List<Submission>
}
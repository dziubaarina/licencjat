package com.licencjat.ports.input.submission

import com.licencjat.ports.input.submission.dto.CreateSubmissionCommand
import com.licencjat.ports.input.submission.dto.SubmissionResponse

interface SubmissionService {
    fun createSubmission(command: CreateSubmissionCommand): SubmissionResponse
    fun getSubmissionsForTask(taskId: Long): List<SubmissionResponse>
    fun getSubmissionsForDancer(dancerId: Long): List<SubmissionResponse>
}
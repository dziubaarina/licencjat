package com.licencjat.ports.input.submission

import com.licencjat.ports.input.submission.dto.CreateSubmissionCommand
import com.licencjat.ports.input.submission.dto.GradeSubmissionCommand
import com.licencjat.ports.input.submission.dto.SubmissionResponse

interface SubmissionService {
    fun createSubmission(command: CreateSubmissionCommand): SubmissionResponse
    fun gradeSubmission(command: GradeSubmissionCommand): SubmissionResponse
    fun getSubmissionsForTask(taskId: Long): List<SubmissionResponse>
    fun getSubmissionsForDancer(dancerId: Long): List<SubmissionResponse>
}
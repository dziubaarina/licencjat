package com.licencjat.interfaces.submission

import com.licencjat.ports.input.submission.SubmissionService
import com.licencjat.ports.input.submission.dto.CreateSubmissionCommand
import com.licencjat.ports.input.submission.dto.SubmissionResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/submissions")
class SubmissionController(
    private val submissionService: SubmissionService
) {

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun createSubmission(
        @RequestParam("taskId") taskId: Long,
        @RequestParam("dancerId") dancerId: Long,
        @RequestParam("file") file: MultipartFile
    ): SubmissionResponse {
        val command = CreateSubmissionCommand(
            taskId = taskId,
            dancerId = dancerId,
            file = file
        )
        return submissionService.createSubmission(command)
    }

    @GetMapping("/task/{taskId}")
    fun getByTask(@PathVariable taskId: Long): List<SubmissionResponse> {
        return submissionService.getSubmissionsForTask(taskId)
    }

    @GetMapping("/dancer/{dancerId}")
    fun getByDancer(@PathVariable dancerId: Long): List<SubmissionResponse> {
        return submissionService.getSubmissionsForDancer(dancerId)
    }
}
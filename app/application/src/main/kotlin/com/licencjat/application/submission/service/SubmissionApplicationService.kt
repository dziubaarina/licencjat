package com.licencjat.application.submission.service

import com.licencjat.application.submission.mapper.SubmissionDtoMapper
import com.licencjat.domain.model.Submission
import com.licencjat.ports.input.submission.SubmissionService
import com.licencjat.ports.input.submission.dto.CreateSubmissionCommand
import com.licencjat.ports.input.submission.dto.SubmissionResponse
import com.licencjat.ports.output.file.FileStoragePort
import com.licencjat.ports.output.submission.SubmissionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class SubmissionApplicationService(
    private val repository: SubmissionRepository,
    private val mapper: SubmissionDtoMapper,
    private val fileStoragePort: FileStoragePort
) : SubmissionService {

    @Transactional
    override fun createSubmission(command: CreateSubmissionCommand): SubmissionResponse {
        val savedFilePath = fileStoragePort.save(command.file)

        val domain = Submission(
            taskId = command.taskId,
            dancerId = command.dancerId,
            videoUrl = savedFilePath,
            sentAt = LocalDateTime.now(),
            status = "SUBMITTED"
        )

        val saved = repository.save(domain)
        return mapper.toDto(saved)
    }

    override fun getSubmissionsForTask(taskId: Long): List<SubmissionResponse> {
        return repository.findAllByTaskId(taskId).map { mapper.toDto(it) }
    }

    override fun getSubmissionsForDancer(dancerId: Long): List<SubmissionResponse> {
        return repository.findAllByDancerId(dancerId).map { mapper.toDto(it) }
    }
}
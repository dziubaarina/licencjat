package com.licencjat.infrastructure.submission.adapter

import com.licencjat.domain.model.Submission
import com.licencjat.infrastructure.submission.mapper.SubmissionEntityMapper
import com.licencjat.infrastructure.submission.repository.SubmissionJpaRepository
import com.licencjat.ports.output.submission.SubmissionRepository
import org.springframework.stereotype.Service

@Service
class SubmissionRepositoryAdapter(
    private val repository: SubmissionJpaRepository,
    private val mapper: SubmissionEntityMapper
) : SubmissionRepository {

    override fun save(submission: Submission): Submission {
        val entity = mapper.toEntity(submission)
        val saved = repository.save(entity)
        return mapper.toDomain(saved)
    }

    override fun findById(id: Long): Submission? {
        return repository.findById(id).map { mapper.toDomain(it) }.orElse(null)
    }

    override fun findAllByTaskId(taskId: Long): List<Submission> {
        return repository.findAllByTaskId(taskId).map { mapper.toDomain(it) }
    }

    override fun findAllByDancerId(dancerId: Long): List<Submission> {
        return repository.findAllByDancerId(dancerId).map { mapper.toDomain(it) }
    }
}
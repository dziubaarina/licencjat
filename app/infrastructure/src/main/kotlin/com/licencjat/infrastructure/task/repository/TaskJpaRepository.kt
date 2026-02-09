package com.licencjat.infrastructure.task.repository

import com.licencjat.infrastructure.task.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskJpaRepository : JpaRepository<TaskEntity, Long>
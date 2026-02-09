package com.licencjat.infrastructure.file

import com.licencjat.ports.output.file.FileStoragePort
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.UUID

@Component
class LocalFileStorageAdapter : FileStoragePort {

    private val uploadDir = "uploads"

    init {
        val dir = File(uploadDir)
        if (!dir.exists()) dir.mkdirs()
    }

    override fun save(file: MultipartFile): String {
        val fileName = "${UUID.randomUUID()}_${file.originalFilename}"
        val targetFile = File(uploadDir, fileName)

        Files.copy(file.inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)

        return targetFile.path
    }
}
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
        // Używamy tylko UUID jako nazwy — bez oryginalnej nazwy pliku
        // żeby uniknąć spacji, znaków specjalnych i problemów z URL
        val ext = file.originalFilename
            ?.substringAfterLast('.', "")
            ?.lowercase()
            ?.let { if (it.isBlank()) "mp4" else it }
            ?: "mp4"

        val fileName = "${UUID.randomUUID()}.$ext"
        val targetFile = File(uploadDir, fileName)

        Files.copy(file.inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)

        // Zawsze zwracamy względną ścieżkę z forward slashami
        // Frontend zbuduje: http://localhost:8080/uploads/uuid.mp4
        return "uploads/$fileName"
    }
}
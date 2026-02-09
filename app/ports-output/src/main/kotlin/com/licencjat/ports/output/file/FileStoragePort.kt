package com.licencjat.ports.output.file

import org.springframework.web.multipart.MultipartFile

interface FileStoragePort {
    fun save(file: MultipartFile): String
}
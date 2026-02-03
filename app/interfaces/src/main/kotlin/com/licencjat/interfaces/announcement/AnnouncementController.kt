package com.licencjat.interfaces.announcement

import com.licencjat.ports.input.announcement.AnnouncementService
import com.licencjat.ports.input.announcement.dto.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/announcements")
class AnnouncementController(
    private val service: AnnouncementService
) {

    @GetMapping
    fun getAll(): List<AnnouncementResponse> {
        return service.getAllAnnouncements()
    }

    @PostMapping
    fun create(@RequestBody command: CreateAnnouncementCommand): AnnouncementResponse {
        return service.createAnnouncement(command)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody command: UpdateAnnouncementCommand): AnnouncementResponse {
        // Upewniamy się, że ID w komendzie jest zgodne z URL
        return service.updateAnnouncement(command.copy(id = id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteAnnouncement(id)
    }
}
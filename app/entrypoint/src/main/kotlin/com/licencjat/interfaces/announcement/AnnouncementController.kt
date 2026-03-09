package com.licencjat.interfaces.announcement

import com.licencjat.ports.input.announcement.AnnouncementService
import com.licencjat.ports.input.announcement.dto.*
import org.springframework.security.access.prepost.PreAuthorize
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

    @PreAuthorize("hasAuthority('CHOREOGRAPHER', 'ADMIN')")
    @PostMapping
    fun create(@RequestBody command: CreateAnnouncementCommand): AnnouncementResponse {
        return service.createAnnouncement(command)
    }

    @PreAuthorize("hasAuthority('CHOREOGRAPHER')")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody command: UpdateAnnouncementCommand): AnnouncementResponse {
        return service.updateAnnouncement(command.copy(id = id))
    }

    @PreAuthorize("hasAuthority('CHOREOGRAPHER')")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteAnnouncement(id)
    }
}
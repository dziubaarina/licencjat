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

    // NAPRAWIONO: hasAuthority() przyjmuje tylko 1 argument — użyj hasAnyAuthority()
    @PreAuthorize("hasAnyAuthority('CHOREOGRAPHER', 'ADMIN')")
    @PostMapping
    fun create(@RequestBody command: CreateAnnouncementCommand): AnnouncementResponse {
        return service.createAnnouncement(command)
    }

    @PreAuthorize("hasAnyAuthority('CHOREOGRAPHER', 'ADMIN')")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody command: UpdateAnnouncementCommand): AnnouncementResponse {
        return service.updateAnnouncement(command.copy(id = id))
    }

    @PreAuthorize("hasAnyAuthority('CHOREOGRAPHER', 'ADMIN')")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteAnnouncement(id)
    }
}
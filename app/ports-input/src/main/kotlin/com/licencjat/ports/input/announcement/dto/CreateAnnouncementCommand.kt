package com.licencjat.ports.input.announcement.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Dane wymagane do utworzenia nowego ogłoszenia")
data class CreateAnnouncementCommand(
    @field:Schema(description = "Tytuł ogłoszenia", example = "Warsztaty Hip-Hop")
    val title: String,

    @field:Schema(description = "Szczegółowy opis wydarzenia", example = "Zapraszamy na zajęcia...")
    val description: String,

    @field:Schema(description = "ID autora (użytkownika)", example = "1")
    val authorId: Long
)
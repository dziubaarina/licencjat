package com.licencjat.infrastructure.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**") // Pozwalamy na dostęp do wszystkich endpointów
            .allowedOrigins("http://localhost:5173", "http://localhost:5174") // Adres Twojego Reacta (Vite domyślnie ma 5173)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozwolone metody
            .allowedHeaders("*")
            .allowCredentials(true)
    }
}
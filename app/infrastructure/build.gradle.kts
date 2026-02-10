import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    kotlin("plugin.jpa") version "2.1.0"
}

// Konfiguracja zadań (zostawiamy tak jak było u Ciebie)
tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

group = "com.licencjat"
version = "0.0.1-SNAPSHOT"
description = "licencjat"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // === MODUŁY WEWNĘTRZNE ===
    implementation(project(":app:ports-output"))
    implementation(project(":app:domain"))
    implementation(project(":app:entrypoint")) // TU SĄ KONTROLERY - KLUCZOWE!

    // === SPRING BOOT ===
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation") // Walidacja (naprawia błąd providera)

    // === SWAGGER (NAPRAWIONA WERSJA) ===
    // Zmieniono z 2.3.0 na 2.8.5, aby działało ze Spring Boot 3.4.x
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.5")

    // === BAZA DANYCH I NARZĘDZIA ===
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

    // === JWT ===
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    // === TESTY ===
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
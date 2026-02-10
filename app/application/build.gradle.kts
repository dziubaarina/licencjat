import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
}

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
    // Nasze moduły
    implementation(project(":app:ports-input"))
    implementation(project(":app:ports-output"))
    implementation(project(":app:domain"))

    // Podstawy Springa
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // WAŻNE: To zawiera @Transactional (naprawia błąd ze screena)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // WAŻNE: To zawiera AuthenticationManager (naprawia logowanie)
    implementation("org.springframework.boot:spring-boot-starter-security")

    // WAŻNE: To zawiera obsługę JWT (naprawia JwtService)
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    // Testy
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
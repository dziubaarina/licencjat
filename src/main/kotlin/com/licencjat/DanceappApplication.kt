package com.licencjat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.licencjat"])
class DanceappApplication

fun main(args: Array<String>) {
    runApplication<DanceappApplication>(*args)
}

package com.licencjat.infrastructure.config

import liquibase.integration.spring.SpringLiquibase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {

    @Bean
    fun liquibase(dataSource: DataSource): SpringLiquibase {
        val liquibase = SpringLiquibase()
        // Ścieżka do głównego pliku changelog w resources
        liquibase.changeLog = "classpath:db/changelog/db.changelog-master.xml"
        liquibase.dataSource = dataSource
        // Opcjonalnie: zapobiega uruchomieniu liquibase, jeśli chcesz to kontrolować profilami
        liquibase.setShouldRun(true)
        return liquibase
    }
}
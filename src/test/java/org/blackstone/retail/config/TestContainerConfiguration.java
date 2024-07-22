package org.blackstone.retail.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainerConfiguration {

    @Bean
    @ServiceConnection(name = "postgres")
    public PostgreSQLContainer<?> postgreSQLContainer() {
        try (PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.1")
                .withInitScript("schema.sql")) {
            return postgreSQLContainer;
        }
    }
}

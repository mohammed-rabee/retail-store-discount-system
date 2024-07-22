package org.blackstone.retail.repository;

import org.blackstone.retail.config.TestContainerConfiguration;
import org.blackstone.retail.config.TestRepositoryConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers(disabledWithoutDocker = true)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes = {TestRepositoryConfiguration.class,
        TestContainerConfiguration.class})
class UserRepositoryTest {

    @Autowired
    PostgreSQLContainer<?> postgreSQLContainer;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Test Connection To Container")
    void connectionTest() {
        Assertions.assertTrue(postgreSQLContainer.isCreated());
        Assertions.assertTrue(postgreSQLContainer.isRunning());
    }
}
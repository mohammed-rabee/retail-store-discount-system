package org.blackstone.retail.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.blackstone.retail.domain.entity")
@EnableJpaRepositories(basePackages = "org.blackstone.retail.repository")
@AutoConfigureTestEntityManager
public class TestRepositoryConfiguration {

}

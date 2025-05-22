package com.cozy.command.config;


import com.cozy.shared.ServiceConfigurationProperties;
import com.cozy.shared.db.ServiceDataLayerBaseConfiguration;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = "com.cozy.command.*")
class CommandServiceDataLayerConfiguration extends ServiceDataLayerBaseConfiguration {
    protected CommandServiceDataLayerConfiguration(
            @Value("${services.command.name}") String serviceName,
            DataSource dataSource,
            ServiceConfigurationProperties configuration) {
        super(dataSource, configuration.getServiceLiquibaseProperties(serviceName));
    }

    @Bean(name = "commandLiquibaseRunner")
    public SpringLiquibase liquibase() {
        return getSpringLiquibase("commandLiquibaseRunner");
    }

}

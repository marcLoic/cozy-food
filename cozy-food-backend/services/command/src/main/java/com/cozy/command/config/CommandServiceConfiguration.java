package com.cozy.command.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        CommandServiceDataLayerConfiguration.class,
        CommandDomainConfiguration.class,
})
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "services.command.enabled", havingValue = "true")
public class CommandServiceConfiguration {

}

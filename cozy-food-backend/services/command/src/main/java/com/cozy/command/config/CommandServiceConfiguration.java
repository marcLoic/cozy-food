package com.cozy.command.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        CommandServiceDataLayerConfiguration.class,
        AccountDomainConfiguration.class,
})
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "services.account.enabled", havingValue = "true")
public class AccountServiceConfiguration {


}

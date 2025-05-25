/*
 *  Copyright (c) Dntech 2023 - All rights reserved.
 */

package com.cozy.command.config;

import com.cozy.command.core.port.CommandManager;
import com.cozy.command.core.port.in.CommandManagement;
import com.cozy.command.core.port.out.CommandRepository;
import com.cozy.command.infra.CommandRepositoryImpl;
import com.cozy.command.infra.jpa.JpaCommandRepository;
import com.cozy.shared.security.IdPUserManagementAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

class CommandDomainConfiguration {

    @Bean
    @Primary
    public CommandManagement commandManagement(CommandRepository commandRepository, IdPUserManagementAdapter idPUserManagementAdapter) {
        return new CommandManager(commandRepository, idPUserManagementAdapter);
    }

    @Bean
    public CommandRepository commandRepository(JpaCommandRepository commandRepository) {
        return new CommandRepositoryImpl(commandRepository);
    }

}

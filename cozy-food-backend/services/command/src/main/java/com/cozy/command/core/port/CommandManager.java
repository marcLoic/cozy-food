/*
 *  Copyright (c) Dntech 2023 - All rights reserved.
 */

package com.cozy.command.core.port;


import com.cozy.command.core.exception.CommandIntegrityViolationException;
import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.CommandField;
import com.cozy.command.core.model.payload.internal.field.CreateCommandRequest;
import com.cozy.command.core.model.util.CommandUpdater;
import com.cozy.command.core.port.in.CommandManagement;
import com.cozy.command.core.port.out.CommandRepository;
import com.cozy.shared.GenericObjectValidator;
import com.cozy.shared.security.IdPUserManagementAdapter;
import io.vavr.control.Try;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AuthorizationServiceException;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class CommandManager implements CommandManagement {
    private final CommandRepository commandRepository;
    private final IdPUserManagementAdapter idpUserManagementAdapter;

    @Override
    public Try<Command> createCommand(Long userId, CreateCommandRequest request) {
        return this.setupCommand(userId, request);
    }

    @Override
    public Try<List<Command>> listCommands() {
        return this.commandRepository.listCommand();
    }

    @Override
    public Try<Command> findCommandById(Long commandId) {
        return this.commandRepository.findByCommandById(commandId);
    }

    @Override
    public Try<Command> patchCommand(Long commandId, List<CommandField> patchFields) {
        return this.commandRepository.findByCommandById(commandId)
                .flatMap(command -> this.validate(patchFields)
                        .flatMap(_v -> {
                            CommandUpdater commandUpdater = new CommandUpdater(command);
                            patchFields.forEach(commandUpdater::patch);
                            Command commandWithUpdates = commandUpdater.command();
                            return this.commandRepository.createCommand(commandWithUpdates)
                                    .onSuccess(savedListing -> log.info("Command with id {} updated with pathchFields {}", commandId, patchFields));
                        }));
    }

    private Try<Command> setupCommand(Long userId, CreateCommandRequest request) {
        if (request.getQuantity() <= 0) {
            return Try.failure(new IllegalArgumentException("Quantity must be greater than 0"));
        }

        return this.commandRepository.createCommand(
                Command.builder()
                        .accountId(userId)
                        .description(request.getDescription())
                        .dateOfCommand(request.getDateOfCommand())
                        .quantity(request.getQuantity())
                        .build()
        );
    }

    private Try<Void> validate(List<CommandField> patchedFields) {
        Set<ConstraintViolation<CommandField>> violations = GenericObjectValidator.validate(patchedFields);
        if (!violations.isEmpty()) {
            return Try.failure(CommandIntegrityViolationException.with(violations));
        }
        return Try.run(() -> {
        });
    }
}

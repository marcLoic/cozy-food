/*
 *  Copyright (c) Dntech 2023 - All rights reserved.
 */

package com.cozy.command.core.port.in;

import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.CommandField;
import com.cozy.command.core.model.payload.internal.field.CreateCommandRequest;
import io.vavr.control.Try;

import java.util.List;

public interface CommandManagement {
    /**
     * Register a new command based on the provided userId and accessToken coming from the authorization server.
     * @param userId  the id of the user on the authorization server
     * @param request the command information
     * @return the newly or existing command
     */
    Try<Command> createCommand(Long userId, CreateCommandRequest request);

    Try<List<Command>> listCommands();

    Try<Command> findCommandById(Long commandId);

    Try<Command> patchCommand(Long commandId, List<CommandField> commandFields);

}

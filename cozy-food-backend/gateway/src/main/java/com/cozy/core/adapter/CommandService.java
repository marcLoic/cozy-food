package com.cozy.core.adapter;

import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.CommandField;
import com.cozy.command.core.model.payload.internal.field.CreateCommandRequest;
import com.cozy.command.core.port.in.CommandManagement;
import com.cozy.infra.ServicesFacade;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CommandService implements CommandManagement {
    private final ServicesFacade serviceFacade;

    @Override
    public Try<Command> createCommand(Long userId, CreateCommandRequest request) {
        return this.serviceFacade.commandService()
                .createCommand(userId, request);
    }

    @Override
    public Try<List<Command>> listCommands() {
        return this.serviceFacade.commandService().listCommands();
    }

    @Override
    public Try<Command> findCommandById(Long commandId) {
        return this.serviceFacade.commandService().findCommandById(commandId);
    }

    @Override
    public Try<Command> patchCommand(Long commandId, List<CommandField> commandFields) {
        return this.serviceFacade.commandService().patchCommand(commandId, commandFields);
    }
}

package com.cozy.command.core.port.out;

import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.CreateCommandRequest;
import io.vavr.control.Try;

import java.util.List;

public interface CommandRepository {

    Try<Command> createCommand(Command command);

    Try<List<Command>> listCommand();

    Try<Command> findByCommandById(Long commandId);

}

package com.cozy.command.infra;

import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.port.out.CommandRepository;
import com.cozy.command.infra.jpa.JpaCommandRepository;
import com.cozy.shared.db.DefaultTryCrudRepository;
import io.vavr.control.Try;

import java.util.List;

public class CommandRepositoryImpl implements CommandRepository {

    private final DefaultTryCrudRepository<Command> crudRepositoryHelper;
    private final JpaCommandRepository repository;

    public CommandRepositoryImpl(JpaCommandRepository repository) {
        this.crudRepositoryHelper = DefaultTryCrudRepository.of(repository, Command.class);
        this.repository = repository;
    }

    @Override
    public Try<Command> createCommand(Command command) { return this.crudRepositoryHelper.save(command); }

    @Override
    public Try<List<Command>> listCommand() {
        return this.crudRepositoryHelper.findAll();
    }

    @Override
    public Try<Command> findByCommandById(Long commandId) {
        return this.crudRepositoryHelper.findById(commandId);
    }
}

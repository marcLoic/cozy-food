package com.cozy.api;

import com.cozy.account.core.AccountManager;
import com.cozy.account.core.model.payload.internal.field.AccountField;
import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.*;
import com.cozy.core.adapter.AccountService;
import com.cozy.core.adapter.CommandService;
import com.cozy.model.*;
import com.cozy.shared.api.DateMapper;
import com.cozy.shared.security.SecurityContextUtil;
import io.vavr.API;
import io.vavr.control.Try;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CommandsServiceApi implements CommandApi {

    private final CommandService commandService;

    private final AccountService accountService;

    @Override
    public ResponseEntity<CommandDto> createCommand(CreateCommandRequestDto createCommandRequestDto) {
        log.info("Creation of a command");
        Try<CreateCommandRequest> createCommandRequest = Try.success(createCommandRequestDto).map(Mapper.INSTANCE::map);
        return API.For(SecurityContextUtil.getAuthenticationToken(), createCommandRequest)
                .yield((token, request) ->
                    accountService.findByIdpUserId(token.getName())
                            .flatMap(account -> this.commandService.createCommand(account.getId(), request))
                )
                .map(Try::get)
                .onSuccess(command -> log.info("Registered new command with id: {}", command.getId()))
                .map(Mapper.INSTANCE::map)
                .map(commandDto -> ResponseEntity.status(HttpStatus.CREATED).body(commandDto))
                .onFailure(e -> log.error("Failed to register user. Reason: {}", e.getMessage()))
                .onFailure(e -> log.debug("This is an error", e))
                .get();
    }

    @Override
    public ResponseEntity<List<CommandDto>> getAllCommands() {
        log.info("Fetching all commands");
        return this.commandService.listCommands()
                .onSuccess(commands -> log.info("Fetch {} accounts", commands.size()))
                .map(CommandsServiceApi.Mapper.INSTANCE::map)
                .map(ResponseEntity::ok)
                .onFailure(e -> log.error("Failed fetch all commands. Reason: {}", e.getMessage()))
                .onFailure(e -> log.debug("", e))
                .get();
    }

    @Override
    public ResponseEntity<CommandDto> findCommandById(Long commandId) {
        log.info("Fetching command with id: {}", commandId);
        return this.commandService.findCommandById(commandId)
                .map(CommandsServiceApi.Mapper.INSTANCE::map)
                .onSuccess(command -> log.info("Found command with id : ", command.getId()))
                .map(ResponseEntity::ok)
                .onFailure(e -> log.error("Failed fetch command with id {}. Reason", commandId, e.getMessage()))
                .onFailure(e -> log.debug("", e))
                .get();
    }

    @Override
    public ResponseEntity<CommandDto> updateCommand(Long commandId, Long accountId, CommandPatchRequestDto commandPatchRequestDto) {
        return this.accountService.isAuthenticatedUserOwnerOrAdmin(accountId)
                .flatMap(_v -> Try.success(commandPatchRequestDto)
                        .map(CommandsServiceApi.Mapper.INSTANCE::map)
                        .flatMap(patchedFields -> this.commandService.patchCommand(commandId, patchedFields))
                        .map(CommandsServiceApi.Mapper.INSTANCE::map)
                        .map(ResponseEntity::ok)
                        .onFailure(e -> log.error("Failed patching command with ID {}. Reason: {}", commandId, e.getMessage()))
                        .onFailure(e -> log.debug("", e))
                )
                .onFailure(e -> {
                    if (e instanceof ConstraintViolationException exception) {
                        log.error("Validation failed with message {}", exception.getMessage());
                        log.error("Validation failed with violations {}", exception.getConstraintViolations());
                        log.error("", exception);
                    }
                })
                .fold(
                        e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(),
                        successResponse -> successResponse
                );
    }

    @org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, uses = {DateMapper.class})
    public interface Mapper {
        Mapper INSTANCE = Mappers.getMapper(Mapper.class);

        CreateCommandRequest map(CreateCommandRequestDto createCommandRequestDto);

        default List<CommandField> map(CommandPatchRequestDto patchRequest) {
            List<CommandField> patchedFields = new ArrayList<>();
            Optional.ofNullable(patchRequest.getDescription())
                    .map(this::map)
                    .ifPresent(patchedFields::add);
            Optional.ofNullable(patchRequest.getQuantity())
                    .map(this::map)
                    .ifPresent(patchedFields::add);
            Optional.ofNullable(patchRequest.getDateOfCommand())
                    .map(this::map)
                    .ifPresent(patchedFields::add);
            Optional.ofNullable(patchRequest.getAccountId())
                    .map(this::map)
                    .ifPresent(patchedFields::add);
            return patchedFields;
        }

        CommandDto map(Command command);

        List<CommandDto> map(List<Command> command);

        DescriptionField map(CommandPatchDescriptionDto descriptionDto);

        QuantityField map(CommandPatchQuantityDto quantityDto);

        DateOfCommandField map(CommandPatchDateOfCommandDto dateOfCommandDto);

        AccountIdField map(CommandPatchAccountIdDto accountIdDto);

    }
}

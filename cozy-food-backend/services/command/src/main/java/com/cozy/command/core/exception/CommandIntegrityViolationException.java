package com.cozy.command.core.exception;

import com.cozy.command.core.model.payload.internal.field.CommandField;
import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor(staticName = "with")
public class CommandIntegrityViolationException extends RuntimeException {
    private final Set<ConstraintViolation<CommandField>> violations;
}

package com.cozy.command.core.model.payload.internal.field;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class CreateCommandRequest {
    private String description;
    private Integer quantity;
    private String accountId;
    private LocalDate dateOfCommand;
}

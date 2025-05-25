package com.cozy.command.core.model.util;

import com.cozy.command.core.model.entity.Command;
import com.cozy.command.core.model.payload.internal.field.*;

public record CommandUpdater(Command command) {

    public void patch(CommandField field) {
        switch (field) {
            case DescriptionField description -> patchDescription(description);
            case QuantityField quantity -> patchQuantity(quantity);
            case DateOfCommandField dateOfCommand -> patchDateOfCommand(dateOfCommand);
            case AccountIdField accountId -> patchAccountId(accountId);
            default -> throw new IllegalArgumentException("Unknown field: " + field.getClass().getSimpleName());
        }

    }

    private void patchDescription(DescriptionField description) {
        command.setDescription(description.getDescription());
    }

    private void patchQuantity(QuantityField quantity) {
        command.setQuantity(quantity.getQuantity());
    }

    private void patchDateOfCommand(DateOfCommandField dateOfCommand) {
        command.setDateOfCommand(dateOfCommand.getDateOfCommand());
    }

    private void patchAccountId(AccountIdField accountId) {
        command.setAccountId(accountId.getAccountId());
    }
}

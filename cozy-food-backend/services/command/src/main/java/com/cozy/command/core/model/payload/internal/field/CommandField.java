package com.cozy.command.core.model.payload.internal.field;


public sealed interface CommandField permits
        DescriptionField,
        QuantityField,
        DateOfCommandField,
        AccountIdField {
}

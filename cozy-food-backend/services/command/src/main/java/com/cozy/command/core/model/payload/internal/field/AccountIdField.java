package com.cozy.command.core.model.payload.internal.field;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class AccountIdField implements CommandField {
    @NotBlank
    private Long accountId;
}

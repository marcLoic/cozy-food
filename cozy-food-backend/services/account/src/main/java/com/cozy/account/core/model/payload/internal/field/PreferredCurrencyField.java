package com.cozy.command.core.model.payload.internal.field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PreferredCurrencyField implements AccountField {
    @NotNull
    @NotBlank
    private String preferredCurrency;
}

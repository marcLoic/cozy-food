package com.cozy.account.core.model.payload.internal.field;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class EmailField implements AccountField {
    @Email
    @NotBlank
    private String email;
}

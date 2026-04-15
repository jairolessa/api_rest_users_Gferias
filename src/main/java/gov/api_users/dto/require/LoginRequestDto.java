package gov.api_users.dto.require;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(
        @NotNull @NotEmpty String cpf,
        @NotNull @NotEmpty String password
) {
}

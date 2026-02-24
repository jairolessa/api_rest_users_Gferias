package gov.api_users.dto.require;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdatePasswordDto {

    @NotBlank(message = "A senha atual não pode ser vazio!")
    private String currentPassword;

    @NotBlank(message = "A nova senha não pode ser vazia!")
    @Size(min = 8, message = "A senha deve conter no mímino 8 caracteres!")
    private String newPassword;
}

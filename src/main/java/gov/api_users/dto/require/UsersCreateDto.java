package gov.api_users.dto.require;

import gov.api_users.model.Department;
import gov.api_users.model.Role;
import gov.api_users.model.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersCreateDto {

    @NotBlank(message = "O nome não pode ser vazio!")
    @Size(min = 5, message = "O nome deve ser completo!")
    private String fullName;

    @NotBlank(message = "O CPF não pode ser vazio!")
//    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotBlank(message = "A senha não pode ser vazia!")
    @Size(min = 6, message = "A senha deve conter no mínimo 8 caracteres!")
    private String password;

    @NotBlank(message = "O cargo não pode ser vazio!")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de usuário não pode ser vazio!")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de acesso não pode ser vazio!")
    private Role role;

    @NotNull(message = "O status não pode ser vazio!")
    private Boolean active = true;
    private List<Department> departments = new ArrayList<>();
}

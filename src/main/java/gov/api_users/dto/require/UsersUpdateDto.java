package gov.api_users.dto.require;

import gov.api_users.model.Department;
import gov.api_users.model.Role;
import gov.api_users.model.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersUpdateDto {

    @NotBlank(message = "O nome não pode ser vazio!")
    private String fullName;

    @NotBlank(message = "O cargo não pode ser vazio!")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de usuário não pode ser vazio!")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de acesso não pode ser vazio!")
    private Role role;

    @NotNull(message = "O Status não pode ser vazio!")
    private Boolean active;
    private List<Department> departments = new ArrayList<>();
}

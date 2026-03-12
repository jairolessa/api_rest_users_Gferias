package gov.api_users.dto.require;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentCreateDto {

    @NotBlank(message = "O nome do departamento não pode ser vazio!")
    private String departmentName;
}

package gov.api_users.dto.require;

import gov.api_users.model.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentCreateDto {

    @NotBlank(message = "O nome do departamento não pode ser vazio!")
    private String departmentName;
}

package gov.api_users.dto.response;

import gov.api_users.model.Department;
import gov.api_users.model.Role;
import gov.api_users.model.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDto {

    private Long id;
    private String fullName;
    private String cpf;
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active;
    private List<Department> departments = new ArrayList<>();
}

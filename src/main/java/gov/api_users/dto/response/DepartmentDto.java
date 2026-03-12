package gov.api_users.dto.response;

import gov.api_users.model.UserDepartment;
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
public class DepartmentDto {

    private Long id;
    private String departmentName;
    private List<UsersSimpleDto> usersList = new ArrayList<>();
}

package gov.api_users.dto.response;

import gov.api_users.model.UserDepartment;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDto {

    private String departmentName;
    private List<UserDepartment> userDepartmentList = new ArrayList<>();
}

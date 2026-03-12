package gov.api_users.service;

import gov.api_users.dto.require.UserDepartmentCreateDto;
import gov.api_users.model.Department;
import gov.api_users.model.UserDepartment;
import gov.api_users.model.Users;
import gov.api_users.repository.UserDepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserDepartmentService {

    private final UserDepartmentRepository userDepartmentRepository;
    private final UsersService usersService;
    private final DepartmentsService departmentsService;

    public void registerUserDepartment(UserDepartmentCreateDto userDepartmentCreateDto){

        Users user = usersService.getUserById(userDepartmentCreateDto.getUserId());

        List<Department> departments = departmentsService.getdepartmentsByIds(userDepartmentCreateDto.getDepartmentsIds());
        List<UserDepartment> userDepartmentList = new ArrayList<>();

        for(Department department : departments){

            UserDepartment userDepartment = new UserDepartment();

            userDepartment.setUser(user);
            userDepartment.setDepartment(department);

            userDepartmentList.add(userDepartment);
        }

        userDepartmentRepository.saveAll(userDepartmentList);
    }
}

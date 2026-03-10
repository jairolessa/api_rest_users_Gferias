package gov.api_users.service;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.mapper.DepartmentMapper;
import gov.api_users.model.Department;
import gov.api_users.repository.DepartmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;
    private final DepartmentMapper departmentMapper;

    public void registerDepartment(DepartmentCreateDto departmentCreateDto){

        Department entity = departmentMapper.toEntity(departmentCreateDto);
        System.out.println(entity.toString());
        departmentsRepository.save(entity);
    }
}

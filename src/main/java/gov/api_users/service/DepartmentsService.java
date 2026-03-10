package gov.api_users.service;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.require.DepartmentUpdateListUsersDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.mapper.DepartmentMapper;
import gov.api_users.model.Department;
import gov.api_users.model.Users;
import gov.api_users.repository.DepartmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;
    private final DepartmentMapper departmentMapper;

    public void registerDepartment(DepartmentCreateDto departmentCreateDto){

        Department entity = departmentMapper.toEntity(departmentCreateDto);
        departmentsRepository.save(entity);
    }

    public DepartmentDto getDepartment(Long id){

        Department department = getDepartmentById(id);

        return departmentMapper.toResponseDto(department);
    }

    public List<Department> getDepartments(){
        return departmentsRepository.findAll();
    }

    private Department getDepartmentById(Long id){
        Optional<Department> department = departmentsRepository.findById(id);

        if(department.isEmpty()){
            throw new RuntimeException("Departamento não encontrado!");
        }

        return department.get();
    }
}

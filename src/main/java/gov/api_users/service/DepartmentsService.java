package gov.api_users.service;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.exceptions.ResourceNotFoundException;
import gov.api_users.mapper.DepartmentMapper;
import gov.api_users.model.Department;
import gov.api_users.repository.DepartmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        System.out.println(department.getUserDepartmentList()
                .get(0)
                .getUser()
                .getFullName()
        );
        return departmentMapper.toDto(department);
    }

    public List<DepartmentDto> getDepartments(){

        List<Department> departments = departmentsRepository.findAll();

        return departmentMapper.toListDto(departments);
    }

    public List<Department> getdepartmentsByIds(List<Long> ids){
        return departmentsRepository.findAllById(ids);
    }

    private Department getDepartmentById(Long id){
        Optional<Department> department = departmentsRepository.findById(id);

        if(department.isEmpty()){
            throw new ResourceNotFoundException("Departamento não encontrado!");
        }

        return department.get();
    }
}

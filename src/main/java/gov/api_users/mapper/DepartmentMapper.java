package gov.api_users.mapper;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userDepartmentList", ignore = true)
    Department toEntity(DepartmentCreateDto departmentCreateDto);

    DepartmentDto toDto(Department department);
}

package gov.api_users.mapper;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toEntity(DepartmentCreateDto departmentCreateDto);

    DepartmentCreateDto toDto(Department department);

    DepartmentDto toResponseDto(Department department);
}

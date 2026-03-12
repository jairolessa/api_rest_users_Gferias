package gov.api_users.mapper;

import gov.api_users.dto.require.DepartmentCreateDto;
import gov.api_users.dto.response.DepartmentDto;
import gov.api_users.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserDepartmentMapper.class)
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userDepartmentList", ignore = true)
    Department toEntity(DepartmentCreateDto departmentCreateDto);

    @Mapping(target = "users", source = "userDepartmentList")
    DepartmentDto toDto(Department department);

    List<DepartmentDto> toListDto(List<Department> departmentList);
}

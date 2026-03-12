package gov.api_users.mapper;

import gov.api_users.dto.response.DepartmentSimpleDto;
import gov.api_users.dto.response.UsersSimpleDto;
import gov.api_users.model.UserDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDepartmentMapper {

    @Mapping(target = "id", source = "department.id")
    @Mapping(target = "departmentName", source = "department.departmentName")
    DepartmentSimpleDto toDeparmentDto(UserDepartment userDepartment);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "fullName", source = "user.fullName")
    UsersSimpleDto toUserDto(UserDepartment userDepartment);
}

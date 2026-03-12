package gov.api_users.mapper;

import gov.api_users.dto.require.UsersCreateDto;
import gov.api_users.dto.require.UsersUpdateDto;
import gov.api_users.dto.response.UsersDto;
import gov.api_users.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserDepartmentMapper.class)
public interface UsersMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userDepartmentList", ignore = true)
    Users toEntity (UsersCreateDto usersCreateDto);

    @Mapping(target = "departments", source = "userDepartmentList")
    UsersDto toDto(Users user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userDepartmentList", ignore = true)
    void updateToEntity(UsersUpdateDto usersUpdateDto, @MappingTarget Users users);

    List<UsersDto> toListDto(List<Users> users);
}

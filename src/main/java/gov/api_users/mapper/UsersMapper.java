package gov.api_users.mapper;

import gov.api_users.dto.require.UserUpdatePasswordDto;
import gov.api_users.dto.require.UsersCreateDto;
import gov.api_users.dto.require.UsersUpdateDto;
import gov.api_users.dto.response.UsersDto;
import gov.api_users.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toEntity (UsersCreateDto usersCreateDto);

    UsersDto toDto(Users user);

    void updateToEntity(UsersUpdateDto usersUpdateDto, @MappingTarget Users users);

    List<UsersDto> toListDto(List<Users> users);


}

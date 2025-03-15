package com.java220.Trendiva.mapper;

import com.java220.Trendiva.dto.response.UserResponseDto;
import com.java220.Trendiva.dto.request.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "deleted", target = "isDeleted")
    UserResponseDto toUserResponseDto(User user);

    User toUser(UserSaveRequestDto userSaveRequestDto);


}

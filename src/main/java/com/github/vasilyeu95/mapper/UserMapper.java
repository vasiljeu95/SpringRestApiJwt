package com.github.vasilyeu95.mapper;

import com.github.vasilyeu95.dto.NewUserDto;
import com.github.vasilyeu95.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserMapper
 *
 * @author Stepan Vasilyeu
 * @since 06.07.2022
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    NewUserDto toUserDTO(User user);
    User toUser(NewUserDto userDTO);
    List<NewUserDto> toUserDTOList(List<User> users);
}

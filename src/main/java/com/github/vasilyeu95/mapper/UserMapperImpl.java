package com.github.vasilyeu95.mapper;

import com.github.vasilyeu95.dto.NewUserDto;
import com.github.vasilyeu95.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserMapperImpl
 *
 * @author Stepan Vasilyeu
 * @since 06.07.2022
 */
@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public NewUserDto toUserDTO(User user) {
        return null;
    }

    @Override
    public User toUser(NewUserDto userDTO) {
        return null;
    }

    @Override
    public List<NewUserDto> toUserDTOList(List<User> users) {
        return null;
    }
}

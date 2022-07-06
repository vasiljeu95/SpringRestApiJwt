package com.github.vasilyeu95.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasilyeu95.model.Role;
import com.github.vasilyeu95.model.Status;
import com.github.vasilyeu95.model.User;
import lombok.Data;
import java.util.List;

/**
 * AdminUserDto
 *
 * @author Stepan Vasilyeu
 * @since 06.07.2022
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setFirstName(user.getFirstname());
        adminUserDto.setLastName(user.getLastname());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}

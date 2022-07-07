package com.github.vasilyeu95.dto;

import com.github.vasilyeu95.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NewUsrDto
 *
 * @author Stepan Vasilyeu
 * @since 06.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public User toUser () {
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);

        return user;
    }
}

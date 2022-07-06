package com.github.vasilyeu95.dto;

import com.github.vasilyeu95.model.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * RegistrationRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 06.07.2022
 */
@Data
public class RegistrationRequestDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "1")})
//    private List<Role> roleList;
}

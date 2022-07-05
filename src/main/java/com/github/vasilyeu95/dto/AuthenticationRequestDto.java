package com.github.vasilyeu95.dto;

import lombok.Data;

/**
 * AuthenticationRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 05.07.2022
 */
@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}

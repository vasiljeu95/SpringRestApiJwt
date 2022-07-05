package com.github.vasilyeu95.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * JwtAuthenticationException
 *
 * @author Stepan Vasilyeu
 * @since 05.07.2022
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}

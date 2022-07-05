package com.github.vasilyeu95.security.jwt;

import com.github.vasilyeu95.model.Role;
import com.github.vasilyeu95.model.Status;
import com.github.vasilyeu95.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JwtUserFactory
 *
 * @author Stepan Vasilyeu
 * @since 05.07.2022
 */
public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                        user.getId(),
                        user.getUsername(),
                        user.getFirstname(),
                        user.getLastname(),
                        user.getEmail(),
                        user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoleList()))
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities (List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

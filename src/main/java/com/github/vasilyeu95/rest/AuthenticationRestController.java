package com.github.vasilyeu95.rest;

import com.github.vasilyeu95.dto.AuthenticationRequestDto;
import com.github.vasilyeu95.dto.NewUserDto;
import com.github.vasilyeu95.mapper.UserMapperImpl;
import com.github.vasilyeu95.model.User;
import com.github.vasilyeu95.security.jwt.JwtTokenProvider;
import com.github.vasilyeu95.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * AdminRestControllerV1
 *
 * @author Stepan Vasilyeu
 * @since 05.07.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth/")
public class AuthenticationRestController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImpl userService;
    private final UserMapperImpl userMapper;

//    @Autowired
//    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserServiceImpl userService, UserMapper userMapper) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userService = userService;
//        this.userMapper = userMapper;
//    }

    @PostMapping("login")
    public ResponseEntity login (@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        try {
            String username = authenticationRequestDto.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, authenticationRequestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoleList());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username and password");
        }
    }

    @PostMapping("registration")
    public ResponseEntity<NewUserDto> registration(@RequestBody NewUserDto userDto) {
        if (userService.existByUsername(userDto.getUsername()) || userService.existByEmail(userDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.register(userMapper.toUser(userDto));
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}

package com.github.vasilyeu95.repository;

import com.github.vasilyeu95.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author Stepan Vasilyeu
 * @since 04.07.2022
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String name);
}

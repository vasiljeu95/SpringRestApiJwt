package com.github.vasilyeu95.repository;

import com.github.vasilyeu95.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}

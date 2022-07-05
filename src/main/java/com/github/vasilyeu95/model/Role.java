package com.github.vasilyeu95.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Role
 *
 * @author Stepan Vasilyeu
 * @since 04.07.2022
 */
@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
    private List<User> userList;

}

package com.users.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class CustomUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    private String password;

    private String email;

    public CustomUser(String name, Role role, String password, String email) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
    }

}

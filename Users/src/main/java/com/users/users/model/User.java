package com.users.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.jaxb.SourceType;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Size(min = 3, max = 15)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}

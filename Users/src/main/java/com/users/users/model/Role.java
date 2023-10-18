package com.users.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Size(min = 3, max = 15)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

}

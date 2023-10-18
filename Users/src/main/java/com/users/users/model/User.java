package com.users.users.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.boot.jaxb.SourceType;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Role role;

}

package com.users.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity(name = "users")
@Data
public class UserSaveModel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Size(min = 3, max = 15)
    private String name;

    private int role_id;
}

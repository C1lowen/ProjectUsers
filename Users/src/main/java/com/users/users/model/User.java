package com.users.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.boot.jaxb.SourceType;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity(name = "users")
@Data
public class User {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private int role_id;

}

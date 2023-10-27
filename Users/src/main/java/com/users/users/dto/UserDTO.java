package com.users.users.dto;



import lombok.Data;

@Data
public class UserDTO {

    private int id;


    private String name;


    private String role;

    private String password;

    private String email;

    public UserDTO(int id, String name, String role, String password, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
    }
}

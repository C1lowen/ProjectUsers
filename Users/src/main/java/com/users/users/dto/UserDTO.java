package com.users.users.dto;


import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    private int id;

    @Size(min = 3, max = 15)
    private String name;

    @Size(min = 3, max = 15)
    private String role;

    public UserDTO(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}

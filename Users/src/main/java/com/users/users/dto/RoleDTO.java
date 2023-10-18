package com.users.users.dto;

import com.users.users.model.User;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RoleDTO {

    private int id;
    private Map<String, List<User>> infoRoles;

    public RoleDTO(int id, Map<String, List<User>> infoRoles) {
        this.id = id;
        this.infoRoles = infoRoles;
    }
}

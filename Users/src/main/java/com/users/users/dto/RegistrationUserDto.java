package com.users.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.users.model.Role;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
@Data
public class RegistrationUserDto {
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
}

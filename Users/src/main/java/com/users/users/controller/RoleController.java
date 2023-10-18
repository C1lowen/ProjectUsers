package com.users.users.controller;

import com.users.users.dto.RoleDTO;
import com.users.users.model.Role;
import com.users.users.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public List<RoleDTO> getAll() {
        return roleService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody @Validated Role role) {
        roleService.add(role);
    }

    @DeleteMapping ("/remove/{id}")
    public void remove(@PathVariable Integer id) {
        roleService.deleteById(id);
    }

    @GetMapping("/allName/{name}")
    public List<RoleDTO> getByName(@PathVariable String name) {
       return roleService.getByName(name);
    }

}

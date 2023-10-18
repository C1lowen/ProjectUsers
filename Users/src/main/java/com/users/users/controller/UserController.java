package com.users.users.controller;

import com.users.users.model.User;
import com.users.users.model.UserSaveModel;
import com.users.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.users.users.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody @Validated UserSaveModel user) {
        userService.add(user);
    }

    @DeleteMapping ("/remove/{id}")
    public void remove(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/allName/{name}")
    public List<UserDTO> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }


}

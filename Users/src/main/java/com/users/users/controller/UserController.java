package com.users.users.controller;

import com.users.users.model.User;
import com.users.users.model.UserRole;
import com.users.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("/remove/{id}")
    public void remove(@PathVariable Integer id) {
        userService.remove(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping("/allName/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/allJoined")
    public List<UserRole> getAllJoined() {
        return userService.getAllJoined();
    }

}

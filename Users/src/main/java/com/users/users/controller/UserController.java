package com.users.users.controller;

import com.users.users.dto.CreateUserDTO;

import com.users.users.model.CustomUser;
import com.users.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.users.users.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<UserDTO> getAll() {
        return userService.findAll();
    }


//    @PostMapping("/add")
//    public void add(@RequestBody @Validated CustomUser user) {
//        String password = user.getPassword();
//        user.setPassword(passwordEncoder.encode(password));
//
//        userService.add(user);
//    }

    @DeleteMapping ("/remove/{id}")
    public void remove(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/allName/{name}")
    public List<UserDTO> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/findUserName/{name}")
    public CustomUser findByName(@PathVariable String name){
        CustomUser customUser =  userService.findByName(name).orElseThrow(() -> new UsernameNotFoundException (
                String.format("Пользователь %s не найден!", name)
        ));

        return customUser;
    }

    @GetMapping("/secured")
    public String infoSecured(){
        return "Данный метод защищен";
    }

    @GetMapping("/info")
    public String info(){
        return "Тут нахоидтся информация";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Вы вошли как администратор";
    }

}

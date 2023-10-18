package com.users.users.service;
import com.users.users.repository.*;
import com.users.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RoleRepository roleRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getByName(String name) {
        return userRepository.getByName(name);
    }


    public List<User> getAllJoined() {
        return userRepository.getAllJoined();
    }
}

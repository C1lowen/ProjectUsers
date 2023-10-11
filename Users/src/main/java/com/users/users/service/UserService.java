package com.users.users.service;
import com.users.users.model.UserRole;
import com.users.users.repository.*;
import com.users.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public boolean add(User user) {
        return userRepository.add(user);
    }

    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    public boolean update(User user) {
        return userRepository.update(user);
    }


    public List<User> getByName(String name) {
        return userRepository.getByName(name);
    }


    public List<UserRole> getAllJoined() {
        return userRepository.getAllJoined();
    }
}

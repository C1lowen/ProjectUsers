package com.users.users.service;
import com.users.users.dto.CreateUserDTO;
import com.users.users.dto.RoleDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Role;

import com.users.users.repository.*;
import com.users.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<UserDTO> findAll() {
        List<UserDTO> usersDTOFindAll = createListUserDTO(userRepository.findAll());
        return usersDTOFindAll;
    }

    public void add(CreateUserDTO user) {
        Optional<Role> roleFindById = roleRepository.findById(user.getRole());
        if(roleFindById.isEmpty()){
            throw new RuntimeException();
        }

        User newUser = new User(user.getName(), roleFindById.get());
        userRepository.save(newUser);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getByName(String name) {
        List<UserDTO> usersDTOGetByName = createListUserDTO(userRepository.getByName(name));
        return usersDTOGetByName;
    }

    private List<UserDTO> createListUserDTO(List<User> users){
        return users.stream()
                .map(user -> new UserDTO(user.getId(),user.getName(), user.getRole().getName()))
                .collect(Collectors.toList());
    }
}

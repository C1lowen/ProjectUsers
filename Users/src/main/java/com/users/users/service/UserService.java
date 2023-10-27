package com.users.users.service;
import com.users.users.dto.CreateUserDTO;
import com.users.users.dto.UserDTO;
import com.users.users.model.Role;

import com.users.users.repository.*;
import com.users.users.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public List<UserDTO> findAll() {
        return createListUserDTO(userRepository.findAll());
    }

    public void add(CustomUser user) {
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

       userRepository.save(user);
    }

    public Optional<CustomUser> findByName(String name){
       return userRepository.findByName(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = findByName(username).orElseThrow(() -> new UsernameNotFoundException(
                "Пользователь с именем " + username + " не найден"
        ));

        List<GrantedAuthority> roles = Arrays.asList(
                new SimpleGrantedAuthority(user.getRole().toString())
        );

        return new User(user.getName(), user.getPassword(), roles);
    }

    public void createNewUser(CustomUser customUser){
        customUser.setRole(roleRepository.findByName("User").get());
        userRepository.save(customUser);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getByName(String name) {
        return createListUserDTO(userRepository.getByName(name));
    }

    private List<UserDTO> createListUserDTO(List<CustomUser> users){
        return users.stream()
                .map(user -> new UserDTO(user.getId(),user.getName(), user.getRole().getName(),user.getPassword(), user.getEmail()))
                .collect(Collectors.toList());
    }
}

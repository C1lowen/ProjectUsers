package com.users.users.repository;

import com.users.users.model.Role;
import com.users.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> getByName(String name);
}

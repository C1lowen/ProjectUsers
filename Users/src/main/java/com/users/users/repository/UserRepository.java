package com.users.users.repository;

import com.users.users.model.Role;
import com.users.users.model.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getByName(String name);
}

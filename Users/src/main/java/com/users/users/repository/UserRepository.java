package com.users.users.repository;

import com.users.users.model.User;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "update users set name = ?, role_id = ? where id = ?", nativeQuery = true)
    boolean updateUserById(User user);
    List<User> getByName(String name);

    @Modifying
    @Query(value = "update users set name = :name, role_id = :roleId where id = :id", nativeQuery = true)
    boolean update(@Param("name") String name, @Param("roleId") Long roleId, @Param("id") Long id);
}

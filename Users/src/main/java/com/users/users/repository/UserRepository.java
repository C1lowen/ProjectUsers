package com.users.users.repository;

import com.users.users.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {
    List<CustomUser> getByName(String name);
    @Query(value = "select * from users u where u.name = :name", nativeQuery = true)
    Optional<CustomUser> findByName(@Param("name") String name);

}

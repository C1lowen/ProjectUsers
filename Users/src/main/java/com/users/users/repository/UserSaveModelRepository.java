package com.users.users.repository;


import com.users.users.model.UserSaveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSaveModelRepository extends JpaRepository<UserSaveModel, Integer> {

}

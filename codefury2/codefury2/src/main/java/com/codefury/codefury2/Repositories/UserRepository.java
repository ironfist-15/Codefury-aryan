package com.codefury.codefury2.Repositories;


import com.codefury.codefury2.dbkelsa.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAll();
}
package com.codefury.codefury2.Repositories;


import com.codefury.codefury2.dbkelsa.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

        Role findByName(String name);
    }


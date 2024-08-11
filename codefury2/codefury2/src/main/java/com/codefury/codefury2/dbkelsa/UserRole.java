package com.codefury.codefury2.dbkelsa;


import com.codefury.codefury2.UserRoleId;
import jakarta.persistence.*;

@Entity
@Table(name = "users_roles")
@IdClass(UserRoleId.class)
public class UserRole {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    // Default constructor
    public UserRole() {}

    // Parameterized constructor
    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

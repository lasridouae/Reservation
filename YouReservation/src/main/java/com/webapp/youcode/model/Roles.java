package com.webapp.youcode.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Roles {
    private Long id;
    private int roleId;
    private String roleType;
    private Collection<Users> usersByRoleId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_type", nullable = false, length = 50)
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (roleId != roles.roleId) return false;
        if (roleType != null ? !roleType.equals(roles.roleType) : roles.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "rolesByRoleId")
    public Collection<Users> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Collection<Users> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}

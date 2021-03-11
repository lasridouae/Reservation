package com.webapp.youcode.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Roles implements Serializable {
    @Id
    @GeneratedValue
    private Long idRole;
    private String roleType;
    @OneToMany(mappedBy = "idUsers")
    private Collection<Users> users;

    public Roles() {
    }

    public Roles(String roleType, Collection<Users> users) {
        this.roleType = roleType;
        this.users = users;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long roleId) {
        this.idRole = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Collection<Users> getUsers() {
        return users;
    }

    public void setUsers(Collection<Users> users) {
        this.users = users;
    }
}

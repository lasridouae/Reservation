package com.webapp.youcode.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name ="idUsers" )
public class Admin extends Users implements Serializable {

    @OneToOne
    @JoinColumn(name = "idUsers")
    private Users users;

    public Admin() {

    }

    public Admin(Users users) {
        this.users = users;
    }

    public Admin(String nom, String prenom, String email, String password, Admin admin, Apprenant apprenant, Roles roles, Users users) {
        super(nom, prenom, email, password, admin, apprenant, roles);
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

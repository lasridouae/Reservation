package com.webapp.youcode.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name ="user_id" )
public class Admin extends Users implements Serializable {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUsers")
    private Users users;

    public Admin() {

    }

    public Admin(Users users) {
        this.users = users;
    }

    public Admin(String userNom, String userPrenom, String userEmail, String userPassword, Roles role, Users users) {
        super(userNom, userPrenom, userEmail, userPassword, role);
        this.users = users;
    }

    public Admin(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Roles role, Users users) {
        super(userId, userNom, userPrenom, userEmail, userPassword, role);
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
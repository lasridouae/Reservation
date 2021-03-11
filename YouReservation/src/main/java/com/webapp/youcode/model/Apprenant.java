package com.webapp.youcode.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name ="idUsers" )
public class Apprenant extends Users implements Serializable {
    @OneToOne
    @JoinColumn(name = "idUsers")
    private Users users;

    public Apprenant() {

    }
    public Apprenant(Users users) {
        this.users = users;
    }

    public Apprenant(String nom, String prenom, String email, String password, Roles roles, Users users) {
        super(nom, prenom, email, password, roles);
        this.users = users;
    }
}

package com.webapp.youcode.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private Long id;
    private int userId;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int roleId;
    private Collection<Admin> adminsByIdUser;
    private Collection<Apprenant> studentsByIdUser;
    private Roles rolesByRoleId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (roleId != users.roleId) return false;
        if (nom != null ? !nom.equals(users.nom) : users.nom != null) return false;
        if (prenom != null ? !prenom.equals(users.prenom) : users.prenom != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + roleId;
        return result;
    }

    @OneToMany(mappedBy = "useradminByIdUser")
    public Collection<Admin> getAdminsByIdUser() {
        return adminsByIdUser;
    }

    public void setAdminsByIdUser(Collection<Admin> adminsByIdUser) {
        this.adminsByIdUser = adminsByIdUser;
    }

    @OneToMany(mappedBy = "useradminByIdUser")
    public Collection<Apprenant> getStudentsByIdUser() {
        return studentsByIdUser;
    }

    public void setStudentsByIdUser(Collection<Apprenant> studentsByIdUser) {
        this.studentsByIdUser = studentsByIdUser;
    }
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}

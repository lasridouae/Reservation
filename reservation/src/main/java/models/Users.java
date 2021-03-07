package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_tabe", schema = "public", catalog = "reservations")
public class Users implements Serializable{
    private Long id;
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String passwordUser;
    private Role roleTableByIdRole;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nom_user", nullable = true, length = -1)
    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    @Basic
    @Column(name = "prenom_user", nullable = true, length = -1)
    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    @Basic
    @Column(name = "email_user", nullable = true, length = -1)
    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Basic
    @Column(name = "password_user", nullable = true, length = -1)
    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (idUser != users.idUser) return false;
        if (nomUser != null ? !nomUser.equals(users.nomUser) : users.nomUser != null) return false;
        if (prenomUser != null ? !prenomUser.equals(users.prenomUser) : users.prenomUser != null) return false;
        if (emailUser != null ? !emailUser.equals(users.emailUser) : users.emailUser != null) return false;
        if (passwordUser != null ? !passwordUser.equals(users.passwordUser) : users.passwordUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (nomUser != null ? nomUser.hashCode() : 0);
        result = 31 * result + (prenomUser != null ? prenomUser.hashCode() : 0);
        result = 31 * result + (emailUser != null ? emailUser.hashCode() : 0);
        result = 31 * result + (passwordUser != null ? passwordUser.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    public Role getRoleTableByIdRole() {
        return roleTableByIdRole;
    }

    public void setRoleTableByIdRole(Role roleTableByIdRole) {
        this.roleTableByIdRole = roleTableByIdRole;
    }
}

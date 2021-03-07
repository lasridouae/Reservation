package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    private Long id;
    private int idUser;
    private Long idRole;
    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String passwordUser;
    private Integer maxReservation;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_user", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_role", nullable = true)
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
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

    @Basic
    @Column(name = "max_reservation", nullable = true)
    public Integer getMaxReservation() {
        return maxReservation;
    }

    public void setMaxReservation(Integer maxReservation) {
        this.maxReservation = maxReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idUser != student.idUser) return false;
        if (idRole != null ? !idRole.equals(student.idRole) : student.idRole != null) return false;
        if (nomUser != null ? !nomUser.equals(student.nomUser) : student.nomUser != null) return false;
        if (prenomUser != null ? !prenomUser.equals(student.prenomUser) : student.prenomUser != null) return false;
        if (emailUser != null ? !emailUser.equals(student.emailUser) : student.emailUser != null) return false;
        if (passwordUser != null ? !passwordUser.equals(student.passwordUser) : student.passwordUser != null)
            return false;
        if (maxReservation != null ? !maxReservation.equals(student.maxReservation) : student.maxReservation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (idRole != null ? idRole.hashCode() : 0);
        result = 31 * result + (nomUser != null ? nomUser.hashCode() : 0);
        result = 31 * result + (prenomUser != null ? prenomUser.hashCode() : 0);
        result = 31 * result + (emailUser != null ? emailUser.hashCode() : 0);
        result = 31 * result + (passwordUser != null ? passwordUser.hashCode() : 0);
        result = 31 * result + (maxReservation != null ? maxReservation.hashCode() : 0);
        return result;
    }
}

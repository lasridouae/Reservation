package com.webapp.youcode.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Apprenant extends Users implements Serializable {
    private Long id;
    private int userId;
    private int idApprenant;
    private Collection<Reservation> reservationsByIdStd;
    private Users users;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "id_apprenant", nullable = false)
    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apprenant apprenant = (Apprenant) o;

        if (userId != apprenant.userId) return false;
        if (idApprenant != apprenant.idApprenant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + idApprenant;
        return result;
    }

    @OneToMany(mappedBy = "studentByIdSt")
    public Collection<Reservation> getReservationsByIdStd() {
        return reservationsByIdStd;
    }

    public void setReservationsByIdStd(Collection<Reservation> reservationsByIdStd) {
        this.reservationsByIdStd = reservationsByIdStd;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public Users getUsersById() {
        return users;
    }

    public void setUsersById(Users users) {
        this.users = users;
    }

}

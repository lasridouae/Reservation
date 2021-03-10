package com.webapp.youcode.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "nbr_placetable", schema = "public", catalog = "reservation")
public class NbrPlace {
    private Long id;
    private int idNbrplace;
    private int idReservation;
    private int nombre;
    private Date dateAjout;
    private Object typeReservation;
    private Reservation reservationByIdReservation;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_nbrplace", nullable = false)
    public int getIdNbrplace() {
        return idNbrplace;
    }

    public void setIdNbrplace(int idNbrplace) {
        this.idNbrplace = idNbrplace;
    }

    @Basic
    @Column(name = "id_reservation", nullable = false)
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "nombre", nullable = false)
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "date_ajout", nullable = false)
    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Basic
    @Column(name = "type_reservation", nullable = false, length = -1)
    public Object getTypeReservation() {
        return typeReservation;
    }

    public void setTypeReservation(Object typeReservation) {
        this.typeReservation = typeReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NbrPlace nbrPlace = (NbrPlace) o;

        if (idNbrplace != nbrPlace.idNbrplace) return false;
        if (idReservation != nbrPlace.idReservation) return false;
        if (nombre != nbrPlace.nombre) return false;
        if (dateAjout != null ? !dateAjout.equals(nbrPlace.dateAjout) : nbrPlace.dateAjout != null) return false;
        if (typeReservation != null ? !typeReservation.equals(nbrPlace.typeReservation) : nbrPlace.typeReservation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNbrplace;
        result = 31 * result + idReservation;
        result = 31 * result + nombre;
        result = 31 * result + (dateAjout != null ? dateAjout.hashCode() : 0);
        result = 31 * result + (typeReservation != null ? typeReservation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_reservation", referencedColumnName = "id_reservation", nullable = false)
    public Reservation getReservationByIdReservation() {
        return reservationByIdReservation;
    }

    public void setReservationByIdReservation(Reservation reservationByIdReservation) {
        this.reservationByIdReservation = reservationByIdReservation;
    }
}

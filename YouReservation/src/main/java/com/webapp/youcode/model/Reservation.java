package com.webapp.youcode.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Reservation {
    private Long id;
    private int idReservation;
    private Integer idApprenant;
    private Date dateReservation;
    private boolean confirmation;
    private Collection<NbrPlace> nbrPlacetablesByIdReservation;
    private Apprenant apprenantByIdApprenant;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_reservation", nullable = false)
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Basic
    @Column(name = "id_apprenant", nullable = true)
    public Integer getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(Integer idApprenant) {
        this.idApprenant = idApprenant;
    }

    @Basic
    @Column(name = "date_reservation", nullable = false)
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "confirmation", nullable = false)
    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (idReservation != that.idReservation) return false;
        if (confirmation != that.confirmation) return false;
        if (idApprenant != null ? !idApprenant.equals(that.idApprenant) : that.idApprenant != null) return false;
        if (dateReservation != null ? !dateReservation.equals(that.dateReservation) : that.dateReservation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReservation;
        result = 31 * result + (idApprenant != null ? idApprenant.hashCode() : 0);
        result = 31 * result + (dateReservation != null ? dateReservation.hashCode() : 0);
        result = 31 * result + (confirmation ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "reservationByIdReservation")
    public Collection<NbrPlace> getNbrPlacetablesByIdReservation() {
        return nbrPlacetablesByIdReservation;
    }

    public void setNbrPlacetablesByIdReservation(Collection<NbrPlace> nbrPlacetablesByIdReservation) {
        this.nbrPlacetablesByIdReservation = nbrPlacetablesByIdReservation;
    }

    @ManyToOne
    @JoinColumn(name = "id_apprenant", referencedColumnName = "id_apprenant")
    public Apprenant getApprenantByIdApprenant() {
        return apprenantByIdApprenant;
    }

    public void setApprenantByIdApprenant(Apprenant apprenantByIdApprenant) {
        this.apprenantByIdApprenant = apprenantByIdApprenant;
    }
}

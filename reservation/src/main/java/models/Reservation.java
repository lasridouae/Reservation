package models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation_tabe", schema = "public", catalog = "reservations")
public class Reservation implements Serializable {
    private Long id;
    private int idReserv;
    private Date dateReserv;
    private Boolean reservConfirm;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "id_reserv", nullable = false)
    public int getIdReserv() {
        return idReserv;
    }

    public void setIdReserv(int idReserv) {
        this.idReserv = idReserv;
    }

    @Basic
    @Column(name = "date_reserv", nullable = true)
    public Date getDateReserv() {
        return dateReserv;
    }

    public void setDateReserv(Date dateReserv) {
        this.dateReserv = dateReserv;
    }

    @Basic
    @Column(name = "reserv_confirm", nullable = true)
    public Boolean getReservConfirm() {
        return reservConfirm;
    }

    public void setReservConfirm(Boolean reservConfirm) {
        this.reservConfirm = reservConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (idReserv != that.idReserv) return false;
        if (dateReserv != null ? !dateReserv.equals(that.dateReserv) : that.dateReserv != null) return false;
        if (reservConfirm != null ? !reservConfirm.equals(that.reservConfirm) : that.reservConfirm != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReserv;
        result = 31 * result + (dateReserv != null ? dateReserv.hashCode() : 0);
        result = 31 * result + (reservConfirm != null ? reservConfirm.hashCode() : 0);
        return result;
    }
}

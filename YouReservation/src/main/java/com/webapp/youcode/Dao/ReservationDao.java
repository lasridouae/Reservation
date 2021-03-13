package com.webapp.youcode.Dao;
import com.webapp.youcode.model.*;

import java.util.List;

public interface ReservationDao {

    public void addReservation(Reservation reservation);

    public List<Reservation> ReservationList();

    public void removeReservation(int id);

    public Reservation getReservation(int id);

    public void editReservation(Reservation reservation);

}

package com.webapp.youcode.Dao;
import com.webapp.youcode.model.*;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDao {

    public void create(Reservation reservation) throws ClassNotFoundException, SQLException;

    public List<Reservation> getAll();

    public void remove(long id);

    public Reservation getById(long id);

    public Reservation update(Reservation reservation);

}

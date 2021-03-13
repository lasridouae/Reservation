package com.webapp.youcode.DaoImp;
import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.model.Reservation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addReservation(Reservation reservation) {
        sessionFactory.getCurrentSession().save(reservation);
    }

    @Override
    public List<Reservation> ReservationList() {
        return sessionFactory.getCurrentSession().createQuery("from Reservation order by id").list();
    }

    @Override
    public void removeReservation(int id) {
        Reservation reservation = (Reservation) sessionFactory.getCurrentSession().load(Reservation.class, id);
        if (null != reservation) {
            sessionFactory.getCurrentSession().delete(reservation);
        }
    }

    @Override
    public Reservation getReservation(int id) {
        return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, id);
    }

    @Override
    public void editReservation(Reservation reservation) {
        sessionFactory.getCurrentSession().update(reservation);
    }
}

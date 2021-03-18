package com.webapp.youcode.DaoImp;
import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Util.HibernateUtil;
import com.webapp.youcode.model.Reservation;
import com.webapp.youcode.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Component("reservationDao")
public class ReservationDaoImpl implements ReservationDao {

    Session session;

    @Override
    public void create(Reservation reservation)  throws ClassNotFoundException, SQLException{
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(reservation);
            transaction.commit();
            System.out.println("reservation est bien crée !");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reservation> getAll() {
        Session session = null;
        List<Reservation> reservation = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            reservation = session.createQuery("From Reservation").list();
            session.getTransaction().commit();

            System.out.println("reservation lu !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return reservation;

    }


    @Override
    public void remove(long id) {
        Reservation reservation = getById(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
            System.out.println("reservation suprimé !");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    @Override
    public Reservation getById(long id) {
        Reservation reservation = null;
        Session session = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get reservation by id
            reservation = (Reservation) session.get(Reservation.class, id);
            System.out.println("user is !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation reservationUpdate;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        reservationUpdate = (Reservation) session.get(Reservation.class,reservation.getIdReservation());

        if (reservationUpdate != null){
            reservationUpdate.setIdReservation(reservation.getIdReservation());
            reservationUpdate.setDateReservation(reservation.getDateReservation());
            reservationUpdate.setConfirmation(reservation.isConfirmation());
            reservationUpdate.setNbrPlacetablesByIdReservation(reservation.getNbrPlacetablesByIdReservation());
            reservationUpdate.setApprenant(reservation.getApprenant());
            System.out.println("reservation updated");
        }else{
            System.out.println("reservation makinch");
        }
        session.getTransaction().commit();
        return reservationUpdate;
    }

}

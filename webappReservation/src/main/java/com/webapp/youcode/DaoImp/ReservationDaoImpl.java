package com.webapp.youcode.DaoImp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Model.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void Add(Reservation reservation) {
		sessionFactory.getCurrentSession().saveOrUpdate(reservation);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getAllReservation() {
//		
//		return sessionFactory.getCurrentSession().createQuery("From Reservation").list();
//		
		Session session = sessionFactory.getCurrentSession();
		
		List reservations = new ArrayList<Reservation>();
		
		Query query = session.createQuery("from Reservation");
		
		reservations = query.getResultList();
 
		return reservations;
	}

	@Override
	public void remove(long id) {
		Session session = sessionFactory.getCurrentSession();

		Reservation reservation = getById(id);

		session.remove(reservation);
		// TODO Auto-generated method stub

	}

	@Override
	public Reservation getById(long id) {
		Session session = sessionFactory.getCurrentSession();

		Reservation reservation = session.get(Reservation.class, id);

		return reservation;
	}

	@Override
	public Reservation update(Reservation reservation) {
		sessionFactory.getCurrentSession().update(reservation);
        return reservation;

	
	}

}

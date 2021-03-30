package com.webapp.youcode.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;

@Repository
public class ReservationRepository {

	@Autowired

	private SessionFactory sessionFactory;

	public List<Reservation> getAllById(long id) {

		Session session = sessionFactory.getCurrentSession();

		List reservations = new ArrayList<Reservation>();
		Query query = session.createQuery(" from Reservation u  where u.user.idUser =:id");
		query.setParameter("id", id);

		try {

			Users user = (Users) query.getSingleResult();
//			reservations = user.getReservation();

			reservations = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return reservations;
	}

	
}

package com.webapp.youcode.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;

@Repository
public class ReservationRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Reservation> getResByUser(long userId ){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        Query query = session.createQuery("select u from Apprenant u JOIN FETCH u.reservations r where u.userId =:userId ",Users.class);
        query.setParameter("userId", userId);
        List<Reservation> list = query.list();
        session.getTransaction().commit();
        return list;
    }
	
	}

	


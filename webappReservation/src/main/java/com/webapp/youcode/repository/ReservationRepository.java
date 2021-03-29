package com.webapp.youcode.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Model.NbrPlace;
import com.webapp.youcode.Model.Users;

@Repository
public class ReservationRepository {
	
	@Autowired
	
	private SessionFactory sessionFactory;
	
	   public List<NbrPlace> getAllPaceById(long id) {

		   Session session = sessionFactory.getCurrentSession();

	        List nbrPlace = null;

	        try {

	            Query query = session.createQuery(" from Reservation u  where u.user.idUser =:id");

	            query.setParameter("id", id);

	            nbrPlace = query.getResultList();
	        } finally {
	            if (session != null) {
	                session.close();
	            }

	        }
	        return nbrPlace;
	    }
	   
	   
		
}

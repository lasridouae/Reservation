package com.webapp.youcode.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	

}

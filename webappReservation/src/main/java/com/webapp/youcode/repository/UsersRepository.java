package com.webapp.youcode.repository;
import java.util.*;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.webapp.youcode.Model.Users;
@Repository
public class UsersRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Users getByEmail(String userEmail) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Users u where u.userEmail=:userEmail");
		query.setParameter("userEmail",userEmail);
		System.out.println(userEmail);
		List<Users> users = query.getResultList();
		
		if (users.size() > 0) {
			Users user = users.get(0);
			return user;
		}
		
		return null;
	}
}

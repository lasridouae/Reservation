package com.webapp.youcode.repository;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Model.Users;
@Repository
public class UsersRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Users getByEmail(String userEmail, String userPassword) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Users where userEmail=: userEmail and userPassword=: userPassword");
		query.setParameter("userEmail",userEmail);
		query.setParameter("userPassword",userPassword);
	        try {
	            Users users= (Users) query.getSingleResult();
	            return users;
	        }
	        catch (Exception e){
	            return null;
	        }
	    }
	
    public List<Users> getAll() {
    	Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Users> usersList = session.createQuery("From Users  where role.roleName='apprenant'").list();
        session.getTransaction().commit();
        return usersList;
    }


}

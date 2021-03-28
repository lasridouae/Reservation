package com.webapp.youcode.repository;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Model.Roles;
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
	
//	@Transactional
//	public boolean validate(String userEmail, String userPassword) {
//		Transaction transaction = null;
//		Users users = null;
//		try {
//			// start session
//			Session session = sessionFactory.getCurrentSession();
//			transaction = session.beginTransaction();
//			// get user object
//			users = (Users)session.createQuery("from Users where userEmail=: userEmail and userPassword=: userPassword")
//					.setParameter("userEmail",userEmail).uniqueResult();
//			System.out.println(userEmail);
//		
//			if (users != null && users.getUserPassword().equals(userPassword)) {
//				return true;
//				
//			}
//			
//			// commit transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
//	}
	@Transactional
	public Roles getByRole(Long id){
    Roles role = null;
        
        try {
        	Session session = sessionFactory.getCurrentSession();
            role = (Roles) session.get(Roles.class, id);
            System.out.println("role lu !");
        } finally {
            if (sessionFactory != null) {
            	sessionFactory.close();
            }

        }

        return role;
		
	}
}

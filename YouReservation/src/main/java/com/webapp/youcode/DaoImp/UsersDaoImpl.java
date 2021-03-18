package com.webapp.youcode.DaoImp;
import java.util.*;


import javax.persistence.Query;
import javax.transaction.Transactional;

import com.webapp.youcode.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private Session session = null;

	
    @Override
    @Transactional
    public Users getById(long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
            // get User by id
    	
            Users users = session.get(Users.class, id);
//            System.out.println("user is !");
        
        return users;
    }
	
	
	
	

    @Override
    @Transactional
    public void create(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       session.saveOrUpdate(users);

    }

    @Override
    @Transactional
    public List<Users> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

		List users = new ArrayList<Users>();
		
		Query query = session.createQuery("from Users");
		
		users = query.getResultList();
 
		return users;

    }

    @Override
    @Transactional
    public void remove(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		
		Users user = getById(id);
		
		session.delete(user);
    }



    @Override
    @Transactional
    public void update(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();

		Users user = getById(users.getUserId());

		session.update(users);
    }


}

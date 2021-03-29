package com.webapp.youcode.DaoImp;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.youcode.Dao.ApprenantDao;
import com.webapp.youcode.Model.Apprenant;

public class ApprenantDaoImpl implements ApprenantDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void create(Apprenant apprenant) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(apprenant);
		
	}


}

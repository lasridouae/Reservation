package com.webapp.youcode.DaoImp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Dao.NbrPlaceDao;
import com.webapp.youcode.Model.NbrPlace;

@Repository
@Component("NbrPlaceDao")
public class NbrPlaceDaoImpl implements NbrPlaceDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	 @Transactional
	public void create(NbrPlace nbrPlace) {
		sessionFactory.getCurrentSession().saveOrUpdate(nbrPlace);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<NbrPlace> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from NbrPlace").list();
	}

	@Override	
	@Transactional
	public void remove(long id) {
		 NbrPlace nbrPlace = (NbrPlace) sessionFactory.getCurrentSession().load (NbrPlace.class, id);
	        if (null != nbrPlace) {
	            this.sessionFactory.getCurrentSession().remove(nbrPlace);
	        }
		
	}

	@Override
	@Transactional
	public NbrPlace getById(long id) {
		 return (NbrPlace) sessionFactory.getCurrentSession().get(
				 NbrPlace.class, id);
	}

	@Override
	@Transactional
	public NbrPlace update(NbrPlace nbrPlace) {
		sessionFactory.getCurrentSession().update(nbrPlace);
        return nbrPlace;
	}

  
    }


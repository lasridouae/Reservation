package com.webapp.youcode.DaoImp;

import com.webapp.youcode.Dao.NbrPlaceDao;
import com.webapp.youcode.DaoImp.NbrPlaceDaoImpl;
import com.webapp.youcode.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NbrPlaceDaoImpl implements NbrPlaceDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addPlace(NbrPlace nbrPlace) {
        sessionFactory.getCurrentSession().save(nbrPlace);
    }

    @Override
    public List<NbrPlace> placeList() {
        return sessionFactory.getCurrentSession().createQuery("from Reservation order by id").list();
    }

    @Override
    public void removePlace(int id) {
        NbrPlace nbrPlace = (NbrPlace) sessionFactory.getCurrentSession().load(NbrPlace.class, id);
        if (null != nbrPlace) {
            sessionFactory.getCurrentSession().delete(nbrPlace);
        }
    }

    @Override
    public NbrPlace getPlace(int id) {
        return (NbrPlace) sessionFactory.getCurrentSession().get(NbrPlace.class, id);
    }

    @Override
    public void editPlace(NbrPlace nbrPlace) {
        sessionFactory.getCurrentSession().update(nbrPlace);
    }
}

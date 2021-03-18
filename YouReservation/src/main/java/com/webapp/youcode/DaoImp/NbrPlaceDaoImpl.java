package com.webapp.youcode.DaoImp;

import com.webapp.youcode.Dao.NbrPlaceDao;
import com.webapp.youcode.DaoImp.NbrPlaceDaoImpl;
import com.webapp.youcode.Util.HibernateUtil;
import com.webapp.youcode.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public class NbrPlaceDaoImpl implements NbrPlaceDao{

    Session session = null;


    @Override
    public void create(NbrPlace nbrPlace) {

        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(nbrPlace);
            transaction.commit();
            System.out.println("nbrPlace est bien crée !");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<NbrPlace> getAll() {
        List<NbrPlace> nbrPlace = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            nbrPlace = session.createQuery("From NbrPlace ").list();
            session.getTransaction().commit();

            System.out.println("nombre de place lu !");
        } finally {
            if (session != null) {
                session.close();
            }
            return nbrPlace;
        }

    }

    @Override
    public void remove(long id) {
        NbrPlace nbrPlace = getById(id);
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(nbrPlace);
            transaction.commit();
            System.out.println("place suprimé !");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    @Override
    public NbrPlace getById(long id) {
        NbrPlace nbrPlace = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            // get nbrPlace by id
            nbrPlace = (NbrPlace) session.get(NbrPlace.class, id);
            System.out.println("nbr place hiya  !");
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return nbrPlace;
    }

    @Override
    public NbrPlace update(NbrPlace nbrPlace) {
        NbrPlace nbrPlaceUpdate;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        nbrPlaceUpdate = (NbrPlace) session.get(NbrPlace.class,nbrPlace.getIdNbrplace());

        if (nbrPlaceUpdate != null){
            nbrPlaceUpdate.setIdNbrplace(nbrPlace.getIdNbrplace());
            nbrPlaceUpdate.setNombre(nbrPlace.getNombre());
            nbrPlaceUpdate.setDateAjout(nbrPlace.getDateAjout());
            nbrPlaceUpdate.setTypeReservation(nbrPlace.getTypeReservation());
            nbrPlaceUpdate.setReservation(nbrPlace.getReservation());
            System.out.println(" updated");
        }else{
            System.out.println("makinch");
        }
        session.getTransaction().commit();
        return nbrPlaceUpdate;
    }
    }


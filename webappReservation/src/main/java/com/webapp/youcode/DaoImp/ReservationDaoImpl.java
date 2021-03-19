package com.webapp.youcode.DaoImp;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Model.Reservation;

@Repository
@Component("reservationDao")
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	 @Transactional
	public void create(Reservation reservation){
		sessionFactory.getCurrentSession().saveOrUpdate(reservation);
		
	}

	@Override
	 @Transactional
	public List<Reservation> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Reservation").list();
	}

	@Override
	 @Transactional
	public void remove(long id) {
		 Reservation reservation = (Reservation) sessionFactory.getCurrentSession().load (Reservation.class, id);
	        if (null != reservation) {
	            this.sessionFactory.getCurrentSession().remove(reservation);
	        }
	}

	@Override
	 @Transactional
	public Reservation getById(long id) {
		 return (Reservation) sessionFactory.getCurrentSession().get(
				 Reservation.class, id);
	}

	@Override
	 @Transactional
	public Reservation update(Reservation reservation) {
		 sessionFactory.getCurrentSession().update(reservation);
	        return reservation;
	}

 
}

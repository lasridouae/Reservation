//package com.webapp.youcode.DaoImp;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import com.webapp.youcode.Dao.ReservationDao;
//import com.webapp.youcode.Model.Reservation;
//
//@Repository
//@Component("reservationDao")
//public class ReservationDaoImpl implements ReservationDao {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Override
//	public void create(Reservation reservation) throws ClassNotFoundException, SQLException {
//		sessionFactory.getCurrentSession().saveOrUpdate(reservation);
//		
//	}
//
//	@Override
//	public List<Reservation> getAll() {
//		return sessionFactory.getCurrentSession().createQuery("from Reservation").list();
//	}
//
//	@Override
//	public void remove(long id) {
//		 Reservation reservation = (Reservation) sessionFactory.getCurrentSession().load (Reservation.class, id);
//	        if (null != reservation) {
//	            this.sessionFactory.getCurrentSession().remove(reservation);
//	        }
//	}
//
//	@Override
//	public Reservation getById(long id) {
//		 return (Reservation) sessionFactory.getCurrentSession().get(
//				 Reservation.class, id);
//	}
//
//	@Override
//	public Reservation update(Reservation reservation) {
//		 sessionFactory.getCurrentSession().update(reservation);
//	        return reservation;
//	}
//
// 
//}

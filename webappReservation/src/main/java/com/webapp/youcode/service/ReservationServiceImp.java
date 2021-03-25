package com.webapp.youcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Model.Reservation;


@Service
@Transactional
public class ReservationServiceImp  implements ReservationService{
	 @Autowired
	    private ReservationDao reservationDao;

	@Override
	   @Transactional
	public void addReservation(Reservation reservation) {
		  reservationDao.Add(reservation);
		
	}

	@Override
	   @Transactional
	public List<Reservation> getAllReservation() {
		return reservationDao.getAllReservation();
	}

	@Override
	public void deleteReservation(long idReservation) {
		reservationDao.remove(idReservation);
		
	}

	@Override
	public Reservation getReservation(long idReservation) {
		return reservationDao.getById(idReservation);
	}

	@Override
	public Reservation updateReservation(Reservation Reservation) {
		 return reservationDao.update(Reservation);
	}
	
	  public ReservationDao getReservationDao() {
	        return reservationDao;
	    }

	    public void setReservationDao(ReservationDao reservationDao) {
	        this.reservationDao = reservationDao;
	    }

}

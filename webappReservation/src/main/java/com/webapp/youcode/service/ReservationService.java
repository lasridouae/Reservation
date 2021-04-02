package com.webapp.youcode.service;

	import java.util.List;

	import com.webapp.youcode.Model.Reservation;

	public interface ReservationService {
		
		public void addReservation(Reservation reservation);
	    
	    public List<Reservation> getAllReservation();
	 
	    public void deleteReservation(long idReservation);
	 
	    public Reservation getReservation(long idReservation);
	 
	    public Reservation updateReservation(Reservation Reservation);
	    
	    public List<Reservation> getAllById(long id);

	}


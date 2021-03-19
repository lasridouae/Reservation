package com.webapp.youcode.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Model.Reservation;

@Controller
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao ;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
//	public String res( Model model) {
//		model.addAttribute("welcom");
//	System.out.println("Welcom to reservation");
//		return "reservation";
//	}
	@RequestMapping(value = "/reservation", method = RequestMethod.GET )
	public String reservationFrom(Model theModel) {
		
		Reservation reservation = new Reservation();
		
		theModel.addAttribute("reservation",reservation);
		System.out.println(reservation);
		return "reservationForm";
	}
	//controller method to process the reservation form
	@RequestMapping(value ="/reservationForm", method = RequestMethod.POST)
	public String addReservation(@ModelAttribute("reservation") Reservation reservation) {
		reservationDao.create(reservation);
		System.out.println("reservation added");
		return "redirect:/reservation ";
	}
	


}
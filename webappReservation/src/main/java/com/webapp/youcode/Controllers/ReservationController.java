package com.webapp.youcode.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.ReservationRepository;

@Controller
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao ;


	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UsersDao usersDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/reservation", method = RequestMethod.GET )
	public String reservationFrom(Model theModel) {
	    Reservation reservation = new Reservation();
        List<Reservation> reservations = new ArrayList<Reservation>();
        theModel.addAttribute("reservations", reservations);
        System.out.println(reservations);
        
        return "reservation";
	}
	  @RequestMapping(value = "/newReservation", method = RequestMethod.GET)
	    public ModelAndView newRes(ModelAndView theModel) {
	        Reservation reservation = new Reservation();
	         theModel.addObject("reservation", reservation);
	        theModel.setViewName("reservationForm");
	        return theModel;
	    }
	   @RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
	    public String saveReservation(@ModelAttribute("reservation")Reservation reservation) {
	            reservationDao.Add(reservation);
	            System.out.println("reservation done");
	            
	    		return "redirect:/";
	    }
	
//	
//	//controller method to process the reservation form
//	@RequestMapping(value ="/reservationForm", method = RequestMethod.POST)
//	public String addReservation(@ModelAttribute("reservation") Reservation reservation) {
//		reservationDao.create(reservation);
//		System.out.println("reservation added");
//		return "redirect:/reservation ";
//	}
//	


}
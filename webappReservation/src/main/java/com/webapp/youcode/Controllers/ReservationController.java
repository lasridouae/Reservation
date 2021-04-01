package com.webapp.youcode.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.Model.Apprenant;
import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;
import com.webapp.youcode.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao ;
	
	private UsersDao usersDao;

	@Autowired
	private ReservationService reservationService ;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/reservation" )
	public ModelAndView listReservation(ModelAndView theModel) throws IOException {
	 List<Reservation> listReservation = reservationService.getAllReservation();
        theModel.addObject("listReservation", listReservation);
        theModel.setViewName("reservation");
        return theModel;
	}
	
	
	  @RequestMapping(value = "/newReservation", method = RequestMethod.GET)
	    public ModelAndView newRes(ModelAndView theModel) {
	        Reservation reservation = new Reservation();
	         theModel.addObject("reservation", reservation);
	        theModel.setViewName("reservationForm");
	        return theModel;
	    }
	   @RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
	    public ModelAndView saveReservation(@ModelAttribute Reservation reservation) { 
		   reservation.setApprenant((Apprenant) LoginController.user);
		   System.out.println(reservation.getApprenant().getUserEmail());
	            reservationService.addReservation(reservation);
//	            System.out.println("apprenant :"+reservation.getApprenant().getUserPrenom());
	        return new ModelAndView("redirect:/");
	    }
	
 

       @RequestMapping(value = "/deleteReservation", method = RequestMethod.POST)
       public String deleteReservation(HttpServletRequest request){
            Long id = Long.valueOf(request.getParameter("id"));
            Reservation reservation = reservationService.getReservation(id);
            reservation.setConfirmation(false);
            reservationService.updateReservation(reservation);
            return "redirect:/reservation";
       }


    @RequestMapping(value = "/ApprouveReservation", method = RequestMethod.POST)
    public String accepterReservation(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        Reservation reservation = reservationService.getReservation(id);
        reservation.setConfirmation(true);
        reservationService.updateReservation(reservation);
        return "redirect:/reservation";
    }


}
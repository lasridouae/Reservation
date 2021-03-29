package com.webapp.youcode.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.repository.ReservationRepository;
import com.webapp.youcode.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationDao reservationDao ;
	
	private ReservationRepository reservationRespsitory;

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
	            reservationService.addReservation(reservation);
	        return new ModelAndView("redirect:/");
	    }
	   
//	   @RequestMapping(value = "/admin" )
//		public ModelAndView listRes(ModelAndView theModel) throws IOException {
//		 List<Reservation> listReservation = reservationService.getAllReservation();
//	        theModel.addObject("listReservation", listReservation);
//	        theModel.setViewName("admin");
//	        return theModel;
//		}
       @RequestMapping(value = "/deleteReservation", method = RequestMethod.POST)
       public String deleteReservation(HttpServletRequest request){
            Long id = Long.valueOf(request.getParameter("id"));
            reservationService.deleteReservation(id);
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
//	
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
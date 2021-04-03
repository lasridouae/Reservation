package com.webapp.youcode.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.Model.Apprenant;
import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.repository.ReservationRepository;
import com.webapp.youcode.service.ReservationService;

@Controller
public class ReservationController {
	private static final int Reservation = 0;
	@Autowired
	private ReservationDao reservationDao ;
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	private UsersDao usersDao;

	@Autowired
	private ReservationService reservationService ;
	
	@RequestMapping(value = "/reservation" )
	public ModelAndView listReservation(ModelAndView theModel) throws IOException {
	 List<Reservation> listReservation = reservationService.getAllReservation();
        theModel.addObject("listReservation", listReservation);
        theModel.setViewName("reservation");
        return theModel;
	}
	
	//apprenant
	  @RequestMapping(value = "/newReservation", method = RequestMethod.GET)
	    public ModelAndView newRes(ModelAndView theModel, Model model) {
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
	        return new ModelAndView("redirect:/resList");
	    }

    @RequestMapping(value = "/ApprouveReservation", method = RequestMethod.POST)
    public String accepterReservation(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        Reservation reservation = reservationService.getReservation(id);
        reservation.setConfirmation(true);
        reservationService.updateReservation(reservation);
        return "redirect:/reservation";
    }
    

    
	@RequestMapping(value = "/reser" )
	public ModelAndView list(ModelAndView theModel , HttpSession session, Model model, Apprenant apprenant) throws IOException {
		Long userId = (Long) session.getAttribute("id");
		List<Reservation> reservations = reservationRepository.getResByUser((long) userId);
		apprenant.setReservation(reservations);
     	System.out.println(reservations);
		model.addAttribute("list", reservations);	 
        theModel.setViewName("resList");
        return theModel;
	}
	

}
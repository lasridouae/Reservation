package com.webapp.youcode.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.youcode.Dao.ReservationDao;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.ReservationRepository;
import com.webapp.youcode.repository.UsersRepository;
import com.webapp.youcode.service.ReservationService;

@Controller
public class AdminController {

	@Autowired
	private ReservationService reservationService;
	private UsersRepository userRepository;
	private ReservationRepository reservationRespsitory;

	
	@Autowired
	private UsersDao usersDao;
	private ReservationDao reservationDao;
	
	
	@RequestMapping("/adminPage")
	public String showAdmin(Model model, HttpSession session){
		if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
			List<Users> users = usersDao.getAll();
			
			List<Reservation> reservations = reservationDao.getAllReservation();
			
			model.addAttribute("reservations",reservations);
			
			model.addAttribute("users",users);
			
			return "adminPage";
		}else {
			return "redirect:/";
		}
		
	}
	

	
	
	

	
	
	
	
	
//	@RequestMapping(value = "/res", method = RequestMethod.GET)
//	 public String ShoweRes(@ModelAttribute Reservation reservation, Model model){
//
//	        List<Reservation> reservations = reservationService.getAllReservation();
//
//	        model.addAttribute("res",reservations);
//
//
//	        return "Reservation";
//	    }

}//	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
//	public String admin(@ModelAttribute Users users, Model model) {
//
//		List<Users> user = userRepository.getAll();
//
//		model.addAttribute("users", user);
//		System.out.println(user);
//
//		return "adminPage";
//	}
//	
	

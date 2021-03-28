package com.webapp.youcode.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.UsersRepository;
import com.webapp.youcode.service.ReservationService;

@Controller
public class AdminController {

	@Autowired
	private ReservationService reservationService;
	private UsersRepository userRepository;

	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String admin(@ModelAttribute("dashbord")Users users, Model model) {

		List<Users> user = userRepository.getAll();

		model.addAttribute("users", user);
		System.out.println(user);

		return "adminPage";
	}
	
	@RequestMapping(value = "/res", method = RequestMethod.GET)
	 public String ShoweRes(@ModelAttribute Reservation reservation, Model model){



	        List<Reservation> reservations = reservationService.getAllReservation();

	        model.addAttribute("res",reservations);


	        return "Reservation";
	    }

}

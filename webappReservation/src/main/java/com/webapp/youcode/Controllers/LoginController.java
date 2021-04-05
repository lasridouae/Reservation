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

import com.webapp.youcode.Model.Reservation;
import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.ReservationRepository;
import com.webapp.youcode.repository.UsersRepository;

@Controller
public class LoginController {
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	static  Users user = new Users();
	
	// controller method to show the login form
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest request) throws IOException{
		model.addAttribute("users", user);
		model.addAttribute("msg", "");
		return "login";
	}
	
	// controller method to process the login form
	@RequestMapping(value ="/loginAcces", method = RequestMethod.POST)
	public String login(@ModelAttribute Users users,HttpServletRequest request, Model model)
	{

//		UsersRepository userRepository=new UsersRepository();

		users=  userRepository.getByEmail(users.getUserEmail(),users.getUserPassword());
		user = users;
		if (users != null && users.getUserPassword().equals(users.getUserPassword()) == true) {
			HttpSession session = request.getSession(true);
			System.out.println(session.getId());
			session.setAttribute("id",users.getUserId());
			session.setAttribute("userNom",users.getUserNom());
			session.setAttribute("userPrenom",users.getUserPrenom());
			session.setAttribute("role",user.getRole().getRoleName());
			if (session.getAttribute("role").equals("admin")) {
				return "redirect:/users";
			} else if (session.getAttribute("role").equals("apprenant")) {
//				model.addAttribute("users",users);
				return "redirect:/reser";
			}
			System.out.println("login succeed ");
		}
		return "redirect:/";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("logout succeed");
		return "redirect:/login";
	}
	
}
	
	
	
	
	
	
	

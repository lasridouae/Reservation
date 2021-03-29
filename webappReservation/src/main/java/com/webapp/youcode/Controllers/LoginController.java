package com.webapp.youcode.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.UsersRepository;

@Controller
public class LoginController {
	@Autowired
	private UsersRepository userRepository;
	private Users users;
	
	 //get login page
	@RequestMapping(value="/login")
	public String login(Model model) throws IOException{
		model.addAttribute("users", users);
		return "login";
	}
	
	@RequestMapping(value ="/loginAcces", method = RequestMethod.POST)
	public String login(@ModelAttribute Users users, HttpSession session)
	{

//		UsersRepository userRepository=new UsersRepository();

		users=  userRepository.getByEmail(users.getUserEmail(),users.getUserPassword());
		if (users != null && users.getUserPassword().equals(users.getUserPassword()) == true) {
			session.setAttribute("id",users.getUserId());
			session.setAttribute("nom",users.getUserNom());
			session.setAttribute("userPrenom",users.getUserPrenom());
			if (users.getRole().getRoleName().equals("admin")) {
				return "redirect:/admin";
			} else if (users.getRole().getRoleName().equals("apprenant")) {
				return "redirect:/reservation";
			}
			System.out.println("safi rak tlogiti ");
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
	
	
	
	
	
	
	

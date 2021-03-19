package com.webapp.youcode.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.UsersRepository;

@Controller
public class LoginController {
	@Autowired
	private UsersRepository userRepository;
	
	@RequestMapping(value ="/", method = RequestMethod.GET )
	public String showPage(HttpSession session) {
		
		if (session.getAttribute("id") == null) {
			return "login";
		}else {
			if (session.getAttribute("role").equals("admin")) {
				return "redirect:/admin";
			}else {				
				return "redirect:/reservation";
			}
		}
	}
	@RequestMapping(value ="/loginAcces", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session){
		
		String email = request.getParameter("userEmail");
		String password = request.getParameter("userPassword");
		
		Users users = userRepository.getByEmail(email);
		
		if (users != null) {
			if (password.equals(users.getUserPassword())) {
				session.setAttribute("id", users.getUserId());
				session.setAttribute("role", users.getRole());
				if (users.getRole().equals("admin")) {
					return "redirect:/Admin";
				}else {	
					if(users.getRole().equals("Apprenant")){
						//return "redirect:/reservation";
					}else {
						return "redirect:/";
					}
				}
			}else {
				return "redirect:/";
			}
		}else {
			System.out.println("user doesn't exist");
		}
		
		return null;	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("logout succeed");
		return "redirect:/login";
	}
	
}
	
	
	
	
	
	
	

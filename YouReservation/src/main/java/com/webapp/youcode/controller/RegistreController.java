package com.webapp.youcode.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.DaoImp.UsersDaoImpl;
import com.webapp.youcode.model.Users;

@Controller
public class RegistreController {
	
	@Autowired
	private UsersDao usersDao = new UsersDaoImpl();
	
	//controller method to show the registration form
	
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public String registrationFrom(Model theModel) {
		
		Users users = new Users();
		// if registered redirect the user to home
		// else continue
		theModel.addAttribute("users", users);
		System.out.println(users);
		return "register";
	}
	
	//controller method to process the registration form
	@RequestMapping(value ="/processForm", method = RequestMethod.POST)
	public String processFrom(@ModelAttribute("users") Users users) {
		usersDao.create(users);
		System.out.println("register done");
		return "redirect:/";
	}
	


}

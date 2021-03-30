package com.webapp.youcode.Controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.youcode.Dao.ApprenantDao;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.DaoImp.UsersDaoImpl;
import com.webapp.youcode.Model.Apprenant;
import com.webapp.youcode.Model.Roles;
import com.webapp.youcode.Model.Users;

@Controller
public class RegistreController {
	
	@Autowired
	private UsersDao usersDao = new UsersDaoImpl();
	private ApprenantDao apprenantDao ;
	private Users users;

	
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
	public String processFrom(HttpServletRequest request,@ModelAttribute("users") Apprenant users) {
		   Roles role=new Roles();
	        role.setId(2L);
	        users.setRole(role);
	        usersDao.create(users);
	        System.out.println("register done");
	        return "redirect:/login";
		
	}

	


}

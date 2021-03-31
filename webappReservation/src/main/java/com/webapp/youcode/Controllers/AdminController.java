package com.webapp.youcode.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.youcode.Model.Users;
import com.webapp.youcode.repository.UsersRepository;
import com.webapp.youcode.service.UsersService;

@Controller
public class AdminController {
	
	@Autowired
	private UsersService usersService ;
	
	

	
	@RequestMapping(value = "/users" )
	public ModelAndView listUsers(ModelAndView theModel) throws IOException {
		List<Users> listUsers = usersService.getAll();
        theModel.addObject("listUsers", listUsers);
        theModel.setViewName("users");
        return theModel;
	}


	

}
	

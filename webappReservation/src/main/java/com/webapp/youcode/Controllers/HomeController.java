package com.webapp.youcode.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPage(HttpSession session) {

		return "home";

	}

	@RequestMapping(value = "/resList", method = RequestMethod.GET)
	public String test() {
		return "resList";
	}

}
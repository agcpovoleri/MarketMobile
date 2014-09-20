package com.marketmobile.controller.login;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/login")
public class LoginLogoutController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginLogoutController.class);
	
//	//Spring Security see this :
	@RequestMapping(method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		logger.debug("hey bitch!");
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return "content/auth/login";
 
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkLogin(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		
		return "/";
 
	}
	
}

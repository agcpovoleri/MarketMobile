<<<<<<< Updated upstream
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
=======
package com.marketmobile.controller.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketmobile.common.security.dao.UserInfoJdbcUserDetailsManager;
import com.marketmobile.common.security.entity.dao.UserAuthentication;
import com.marketmobile.utils.BasicUtils;


@Controller
public class LoginLogoutController {
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginLogoutController.class);
	
	@Autowired
	private UserInfoJdbcUserDetailsManager userDetailsService;
	
//	//Spring Security see this :
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(null);
		
        return "index";

    }
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkLogin(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView model = new ModelAndView();
		
		logger.info("checking");
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if(username != null) {
			
			UserDetails myUserDetails = null;
			try {
				myUserDetails = userDetailsService.loadUserByUsername(username);
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			if (myUserDetails != null){
				
				if (isMyUserValidated(myUserDetails, password)){
					
					List<GrantedAuthority> listAuth = new ArrayList<GrantedAuthority>();
					listAuth.addAll(myUserDetails.getAuthorities());
					
					UserAuthentication userAuth = new UserAuthentication(username, "regularUser", listAuth);
					
					securityContext.setAuthentication(userAuth);
						
					String name = securityContext.getAuthentication().getName(); //get logged in username
				    model.addObject("username", name);
				    
					return "index";
					
				}else{
					model.addObject("error", "Password doesn't match!");
				}

			}else{
				model.addObject("error", "Usuario not found!");
			}
		}
		
		return "content/auth/login";
	}
	
	/**
	 * Verifica se usuario o password esta correto
	 * @param myUserDetails
	 * @param password
	 * @return
	 */
	private boolean isMyUserValidated(UserDetails myUserDetails, String password) {
		
		if (myUserDetails.getPassword().equals(BasicUtils.passwordMd5Encoder(password))){
			return true;
		}
		return false;
	}

	
}
>>>>>>> Stashed changes

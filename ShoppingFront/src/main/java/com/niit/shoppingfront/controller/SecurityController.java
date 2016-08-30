/*package com.niit.shoppingfront.controller;

import org.apache.tomcat.util.net.jsse.openssl.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.User;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;


@Controller
public class SecurityController {

	@RequestMapping(value = { "/", "/user**" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error",required = false) ,
			@RequestParam(value = "logout", required = false) String error )
	{
		ModelAndView model = new ModelAndView();
		if(error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}
		
		if(logout != null)
		{
			model.addObject("msg","You Have been logged out successfully");
		}
		model.setViewName("login");
		
		return model;
	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403" ,method = RequestMethod.GET)
	public ModelAndView accessDenied()
	{
		ModelAndView model = new ModelAndView();
		
		//check if user is login 
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken))
		{
			User user = (User) auth.getPrinciple(user);
			System.out.println("user");	
			
			model.addObject("username", user.getId());
		
		}
		
		model.setViewName("403");
		return model;
	}
	
}*/
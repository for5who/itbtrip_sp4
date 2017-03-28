package com.itb.framework;

import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Home Start!!");
		return "home";
	}
	
	@RequestMapping(value = "/404page", method = RequestMethod.GET)
	public String error404(){
	
		return "framework/error/404page";
	}
	
	@RequestMapping(value = "/400page", method = RequestMethod.GET)
	public String error400(){
	
		return "framework/error/400page";
	}
	
	@RequestMapping(value = "/405page", method = RequestMethod.GET)
	public String error405(){
	
		return "framework/error/405page";
	}
	
	@RequestMapping(value = "/500page", method = RequestMethod.GET)
	public String error500(){
	
		return "framework/error/500page";
	}
	
}

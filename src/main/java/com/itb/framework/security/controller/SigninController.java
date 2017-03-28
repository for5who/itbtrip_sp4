package com.itb.framework.security.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.itb.framework.common.handler.CustomExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SigninController extends CustomExceptionHandler{

    @RequestMapping(value="/signin.do")
    public ModelAndView signin(HttpServletRequest request,
    		@RequestParam(value="error", required=false) String err) {
    	log.debug("Signin Page start!!!");
 		
    	
 		ModelAndView mav = new ModelAndView();
		mav.setViewName("framework/security/signin");
		return mav;
         
    }
    
    @PreAuthorize("authenticated")
    @RequestMapping(value="/main.do")
    public String main(Model model) {
    	log.debug("Main Page start!!!");

    	/*
    	 * 
    	 * 
    	 * 
    	 */
    	
    	return "framework/main";
    }
}

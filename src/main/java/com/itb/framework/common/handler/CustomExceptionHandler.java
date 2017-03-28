package com.itb.framework.common.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception e) {
 
		//log.error("handleException:" + e.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorCode", 9999);
		modelAndView.addObject("errorMsg", e.getMessage());
 
		// 요청 페이지가 Ajax인지 웹 페이지인지 구분하여 처리
		if (req.getHeader("accept").indexOf("text/html")>=0)
			modelAndView.setViewName("framework/error/error");
		
		return modelAndView;
 	}

	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(HttpServletRequest req, CustomException e) {
 
		//log.error("handleCustomException:" + e.getErrorCode());
		//log.error("handleCustomException:" + e.getErrorMsg());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorCode", e.getErrorCode());
		modelAndView.addObject("errorMsg", e.getErrorMsg());
		
		// 요청 페이지가 Ajax인지 웹 페이지인지 구분하여 처리
		if (req.getHeader("accept").indexOf("text/html")>=0)
			modelAndView.setViewName("framework/error/error");
 
		return modelAndView;
 	}
}

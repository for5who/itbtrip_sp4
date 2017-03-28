package com.itb.framework.security.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.itb.framework.security.dto.UserDTO;
import com.itb.framework.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SigninSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Resource(name="userService")
	private UserService userService;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
	
		log.info("LoginSuccess");
		
		UserDTO userDto = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		HttpSession session = (HttpSession)request.getSession(false);
		session.setAttribute("SessionId", session.getId().trim());
		session.setAttribute("UserId", userDto.getUsername());
		
    	response.setContentType("application/json"); 
		response.setCharacterEncoding("utf-8"); 
		String data = StringUtils.join(new String[] { 
				" { \"response\" : {",
				" \"result\" : success , ",
				" \"code\" : 1 , ",
				" \"message\" : \"로그인 성공\" ",
				"} } " 
		}); 
		PrintWriter out = response.getWriter(); 
		out.print(data); 
		out.flush(); 
		out.close();
		
    }
}

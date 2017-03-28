package com.itb.framework.security.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SigninFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	public static String DEFAULT_TARGET_PARAMETER = "spring-security-redirect-login-failure";
    private String targetUrlParameter = DEFAULT_TARGET_PARAMETER;
    public String getTargetUrlParameter() {
         return targetUrlParameter;
    }
    public void setTargetUrlParameter(String targetUrlParameter) {
        this.targetUrlParameter = targetUrlParameter;
    }
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    	
    	log.info("LoginFailure");
    	
    	System.out.println(exception.getMessage());
    	String errMsg ="";
    	
    	if(exception.getMessage().equals("PwdErr")) {
    		errMsg ="패스워드가 일치하지 않습니다.";
    	}else if(exception.getMessage().equals("NonUser")){
    		errMsg ="사용자가 존재하지 않습니다.";
    	}
    	
    	response.setContentType("application/json"); 
		response.setCharacterEncoding("utf-8"); 
		String data = StringUtils.join(new String[] { 
				" { \"response\" : { ",
				" \"result\":fail, ",
				" \"code\":0, ",
				" \"message\":\""+errMsg+"\" ",
				"} } " 
		}); 
		PrintWriter out = response.getWriter(); 
		out.print(data); 
		out.flush(); 
		out.close();
 
    }
    
}

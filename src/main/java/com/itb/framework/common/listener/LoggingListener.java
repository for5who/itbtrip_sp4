package com.itb.framework.common.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class LoggingListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent hse) {}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		WebApplicationContext wb =WebApplicationContextUtils.getWebApplicationContext(hse.getSession().getServletContext());
		//DB Logging -> 
		
		HttpSession session = hse.getSession();
		
		log.info("[TimeOut:"+(String)session.getAttribute("UserId")+"]"+session.getId()+"- 세션이 소멸되었습니다."); 
			
	
		
	}

}

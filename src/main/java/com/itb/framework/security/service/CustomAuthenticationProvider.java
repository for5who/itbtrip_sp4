package com.itb.framework.security.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.itb.framework.security.dto.RoleDTO;
import com.itb.framework.security.dto.UserDTO;
import com.itb.framework.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Resource(name="userService") 
    UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName(); //폼에서 입력받은 아이디
        String password = (String) authentication.getCredentials(); //폼에서 입력받은 비번
        
        Collection<? extends GrantedAuthority> authorities;
        UserDTO userDto;
       
    	userDto = (UserDTO) userService.loadUserByUsername(username);
   
    	/*********************************
         * 임시 패스워드 체크
         *********************************/
        log.info("P-username : {}  password : {} " , username , password);
        log.info("S-username : {}  password : {} " ,userDto.getUsername(), userDto.getPassword());
      
        //생성시마다 변경되는 암호화 방식 matches로 비교해야함
        if (!password.equals(userDto.getPassword()) ) {
            throw new BadCredentialsException("PwdErr");
        }else if (userDto.getUsername()==null||userDto.getUsername().isEmpty()) {
            throw new BadCredentialsException("NonUser");
        }
         
        /*********************************
         * Spring Security ROLE 부여
         *********************************/
        RoleDTO role = new RoleDTO();
        role.setName("ROLE_USER");
        
        List<RoleDTO> roles = new ArrayList<>();
        roles.add(role);
        userDto.setAuthorities(roles); 
      
        authorities = userDto.getAuthorities();
        
        log.info(username+"-Authorities : {}",userDto.getAuthorities());
	    
		return new UsernamePasswordAuthenticationToken(userDto, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	

}


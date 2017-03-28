package com.itb.framework.security.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itb.framework.security.dao.UserDAO;
import com.itb.framework.security.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userService")
public class UserService implements UserDetailsService {

	@Resource(name="userDao")
	private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("userid: {}",username);
		
		UserDTO userDto = userDao.getUserInfo(username); //DB에서 User정보 조회 */
		
		return userDto;
	}

}

package com.itb.framework.security.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itb.framework.security.dto.UserDTO;

@Repository("userDao")
public class UserDAO {
	
	@Autowired
    private SqlSession maria_sqlSession;
	
	public UserDTO getUserInfo(String username) {
		return maria_sqlSession.selectOne("MARIA.USER.getUserInfo",username);
	}

}

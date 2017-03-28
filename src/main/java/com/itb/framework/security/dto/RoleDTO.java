package com.itb.framework.security.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class RoleDTO  implements GrantedAuthority  {
	
	private static final long serialVersionUID = 1L;
	private String name; //ROLE 명
	private List<Privilege> privileges; //ROLE 권한리스트

	@Override
	public String getAuthority() {
		return this.name;
	}
	
	
}

package com.itb.framework.security.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO implements UserDetails {

	private static final long serialVersionUID = 5129954728321130514L;
	
	private String username;
	private String password;
	
	private List<RoleDTO> authorities;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	@Override
    public int hashCode() {
        return username.hashCode();
    }
    @Override
    public boolean equals(Object o) {
       if (o instanceof UserDTO) {
            return username.equals(((UserDTO) o).username);
       }
       return false;
    } 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}


	
}

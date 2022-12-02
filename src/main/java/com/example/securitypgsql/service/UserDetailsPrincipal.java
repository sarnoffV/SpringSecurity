package com.example.securitypgsql.service;

//import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.securitypgsql.entities.User;

public class UserDetailsPrincipal implements UserDetails {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserDetailsPrincipal (User user) {
		this.user = user;
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		 /*List <GrantedAuthority> roles = new ArrayList<>();
		 roles.add(new SimpleGrantedAuthority("ROLE_"+user.getId().getDescription()));
		 return roles;*/
		 return null;
		 
    }
	
	@Override
    public String getPassword() {
        return user.getPassword();
    }
	
	@Override
	public String getUsername() {
        return user.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
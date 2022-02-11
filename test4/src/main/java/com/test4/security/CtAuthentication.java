package com.test4.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class CtAuthentication implements AuthenticationProvider{
	@Autowired
	private CtUserDetailsService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username=(String)authentication.getPrincipal();
		String password=(String)authentication.getCredentials();
		
		CtUserDetails user=(CtUserDetails)service.loadUserByUsername(username);
		
		if(!matchPassword("{noop}"+password,user.getPassword())) { //비밀번호 맞는지
			throw new BadCredentialsException(username);
		}

		if(!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}

		
		user.setPassword(null); // 비밀번호 감춤
		
		Authentication newauth=new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
		return newauth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private boolean matchPassword(String loginpwd,String password) {
		
		return loginpwd.equals(password);
	}
	
}

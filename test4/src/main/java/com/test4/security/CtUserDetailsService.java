package com.test4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test4.dao.Dao;


@Service
public class CtUserDetailsService implements UserDetailsService{
	@Autowired
	private Dao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CtUserDetails user=dao.userlogin(username);

		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
}

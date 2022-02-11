package com.test4.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("seria1")
public class CtUserDetails implements UserDetails {
	
	private String memid;
	private String memname;
	private String mempwd;
	private String AUTHORITY;
	private String membirth;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<GrantedAuthority> auth=new ArrayList<GrantedAuthority>();
		
		auth.add(new SimpleGrantedAuthority(AUTHORITY));
		System.out.println("이거에요~"+auth.toString());
		return auth;
	}
	
	public String getMembirth() {
		return membirth;
	}

	public void setMembirth(String membirth) {
		this.membirth = membirth;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "{noop}"+mempwd;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return memid;
	}
	public void setPassword(String password) {
		this.mempwd=password;
	}
	
	
	public void setMemid(String memid) {
		this.memid = memid;
	}
	
	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}

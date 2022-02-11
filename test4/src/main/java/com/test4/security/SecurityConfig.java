package com.test4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	CtUserDetailsService userservice;
	@Autowired
	CtAuthentication customauth;
	@Autowired
	LoginFail fail;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		 http
         .authorizeRequests()
         .antMatchers("/board/write").hasAnyAuthority("USER","ADMIN")
         .anyRequest().permitAll()
 			.and()
             .formLogin()
             .loginPage("/login")
             .loginProcessingUrl("/loginOk")
             .usernameParameter("loginid")
             .passwordParameter("loginpwd")
             .defaultSuccessUrl("/", true)
             .failureHandler(fail)
             .permitAll()
         .and()
             .logout()
             .logoutSuccessUrl("/") // 로그아웃 성공시 리다이렉트 주소
             .and()
     		.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		auth.authenticationProvider(customauth).userDetailsService(userservice);

	}
	

}

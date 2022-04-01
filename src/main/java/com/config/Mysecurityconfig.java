package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
@Configuration
public class Mysecurityconfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		http.authorizeRequests().antMatchers("/login","/signup").permitAll().anyRequest().authenticated().and().httpBasic();
//		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().authenticated().and().httpBasic();
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").antMatchers("/public/**").permitAll().anyRequest().authenticated().and().formLogin();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passencode().encode("pass")).roles("USER");
		auth.inMemoryAuthentication().withUser("user2").password(passencode().encode("pass2")).roles("ADMIN");	
		
		//dynamic --> signup -- login --database 
		//table 
		//insert query 
		//select query 
		//ORM -> object relational mapping 
	}
	@Bean
	public BCryptPasswordEncoder passencode() {
		return new BCryptPasswordEncoder(10);
	}
}

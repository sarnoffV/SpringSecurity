package com.example.securitypgsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.securitypgsql.service.UserService; 

@EnableWebSecurity
@SpringBootApplication
public class SecuritypgsqlApplication extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SecuritypgsqlApplication.class, args);
	}
	
	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(daoAuthenticationprovider());
	}
		
	@Bean
	DaoAuthenticationProvider daoAuthenticationprovider() {
		DaoAuthenticationProvider daoAuthenticationprovider = new DaoAuthenticationProvider();
		
		daoAuthenticationprovider.setPasswordEncoder(bcryptPasswordEncoder());
		daoAuthenticationprovider.setUserDetailsService(userService);
		
		return daoAuthenticationprovider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable().authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/ajouterRole").permitAll()
		.antMatchers("/ajouterUser").permitAll()
		.antMatchers("/admin").hasAnyRole("ADMIN") /*ROLE_ADMIN*/
		.anyRequest().authenticated().and().httpBasic();
	}
}

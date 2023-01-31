package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class SecurityConfig extends 
                       WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.anonymous().disable().csrf().disable()
		   .authorizeRequests()
		     .antMatchers("/oauth/token").permitAll();
		
	}


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("india")
		.password(encoder.encode("india")).roles("ADMIN")
		 .and().withUser("nepal").password(encoder.encode("nepal")).roles("USER");
	}

	
	
}

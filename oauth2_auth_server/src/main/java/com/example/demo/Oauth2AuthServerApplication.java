package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@SpringBootApplication
public class Oauth2AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthServerApplication.class, args);
	}

	 @Bean
	    public BCryptPasswordEncoder encoder() {
	    	
	    	return new BCryptPasswordEncoder();
	    }
	 
		@Bean
		public TokenStore tokenStore() {
			return new InMemoryTokenStore();
		}

}

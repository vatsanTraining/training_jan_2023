package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.CibilScore;
import com.example.demo.repos.ScoreRepository;
import com.netflix.discovery.converters.Auto;

@SpringBootApplication
public class CibilScoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CibilScoreServiceApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			ScoreRepository repo;
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				repo.save(new CibilScore("abc123", 500));
				repo.save(new CibilScore("pqr456", 600));
			}
		};
	}

}

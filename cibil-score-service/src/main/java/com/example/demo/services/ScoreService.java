package com.example.demo.services;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.Tracer.SpanInScope;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CibilScore;
import com.example.demo.repos.ScoreRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2

public class ScoreService {

	private ScoreRepository repo;
	private Tracer tracer;

	@NewSpan(name = "second span")
	public CibilScore findById(String panNumber) {
		
		
	    
	    try  {
	        Thread.sleep(1000L);
	        log.info("I'm in the new span doing some cool work that needs its own span");

			return this.repo.findById(panNumber).orElseThrow(() -> new RuntimeException("Pan Number Not Found "));

	    } catch (InterruptedException e) {
			e.printStackTrace();
		} 
       return null;
		
	}

	   
}

package com.example.demo.services;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.Tracer.SpanInScope;
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

	public CibilScore findById(String panNumber) {
		
		
	    Span newSpan = tracer.nextSpan().name("second span").start();
	    try (SpanInScope ws = tracer.withSpan(newSpan.start())) {
	        Thread.sleep(1000L);
	        log.info("I'm in the new span doing some cool work that needs its own span");

			return this.repo.findById(panNumber).orElseThrow(() -> new RuntimeException("Pan Number Not Found "));

	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        newSpan.end();;
	    }
       return null;
		
	}

}

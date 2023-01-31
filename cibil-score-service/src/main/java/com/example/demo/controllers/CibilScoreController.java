package com.example.demo.controllers;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CibilScore;
import com.example.demo.services.ScoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
@Log4j2
public class CibilScoreController {

	
	private Tracer tracer;
	private ScoreService service;
	
	@GetMapping(path = "/scores/{panNumber}")
	public CibilScore getScoreByPan(@PathVariable("panNumber") String panNumber) {
		


    log.info("I'm in the Controller");

		return this.service.findById(panNumber);
		
	}
   
	
}
	
	
	
	
	// Span newSpan = tracer.nextSpan().name("newSpan").start();

    //Span span = tracer.newTrace().name("encode").start();
//span.tag("clnt/finagle.version", "6.36.0");
//spring.zipkin.baseUrl: https://zipkinserver/

//}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentController {

	
	@Autowired
	StreamBridge bridge;
	
	
	@PostMapping(path = "/student")
	public ResponseEntity<String> addStudent(@RequestBody Student entity){
		
		String message ="Student Details NOT Sent -Check Console";
		
		boolean result =bridge.send("student-topic", entity);
		
		if(result) {
			message ="Student details sent";
		}
		
		return ResponseEntity.ok(message);
	}
	
	
}

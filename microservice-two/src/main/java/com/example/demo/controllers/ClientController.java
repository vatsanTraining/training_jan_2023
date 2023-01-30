package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.LoanApplicationDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {

	
	private RestTemplate template;
	
	
	@GetMapping(path = "/client/loanapplications")
	public LoanApplicationDto[] getAllLoanApplications() {
		
		return template.getForObject("http://SERVICE-ONE/api/v1/loanapplications", LoanApplicationDto[].class);
		
	}
	
	@GetMapping(path = "/client/loanapplications/{id}")
	public LoanApplicationDto getById(@PathVariable("id") int id) {
		
		String url = "http://SERVICE-ONE/api/v1/loanapplications/"+id;
		
		return template.getForObject(url, LoanApplicationDto.class);
		
	}
}

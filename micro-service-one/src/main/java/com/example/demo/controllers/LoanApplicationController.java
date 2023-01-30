package com.example.demo.controllers;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.LoanApplication;
import com.example.demo.services.LoanApplicationService;
import com.netflix.discovery.converters.Auto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1")
public class LoanApplicationController {
	
	
	@Autowired
	private LoanApplicationService service;
	
	@Value("${server.port}")
	private String number;
	
	
	@PostMapping(path = "/loanapplications")
	public ResponseEntity<LoanApplication> save(@RequestBody LoanApplication entity) {
		
        
		URI location=
		           ServletUriComponentsBuilder
		           .fromCurrentRequest()
		           .path("/{id}")
		           .buildAndExpand(entity.getApplicationNumber())
		           .toUri();  

       return ResponseEntity.created(location).body(service.save(entity));
       

	}
	
	
	@GetMapping(path = "/loanapplications")
	public List<LoanApplication> findAll() {
		
		return this.service.findAll();
	}
	

//	@GetMapping(path = "/loanapplications/{id}")
//	public LoanApplication findById(@PathVariable("id") int id) {
//		
//		return this.service.findById(id);
//	}

	@GetMapping(path = "/loanapplications/{id}")
	public LoanApplication findById(@PathVariable("id") int id) {
		
		LoanApplication obj =this.service.findById(id);
		
		
		
		 obj.setPanNumber(this.number);
		 
		 return obj;
	}
	
	
	@GetMapping(path = "/loanapplications/sort/{propName}")
	public List<LoanApplication> sortByProp(@PathVariable("propName") String propName) {
		
		return this.service.findAllSortedBy(propName);
	}
	

	@PutMapping(path = "/loanapplications")
	public LoanApplication update(@RequestBody LoanApplication entity) {
		
        		
       return this.service.update(entity);
       

	}

  @DeleteMapping(path ="/loanapplications/{id}" )
  public LoanApplication remove(@PathVariable("id") int id) {
	  
	  return this.service.remove(id);
  }
  
  
}

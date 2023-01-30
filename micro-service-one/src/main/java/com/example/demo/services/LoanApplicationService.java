package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoanApplication;
import com.example.demo.ifaces.LoanApplicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanApplicationService {

	
	private LoanApplicationRepository repo;
	
	
	public LoanApplication save(LoanApplication entity) {
		
		
		return this.repo.save(entity);
	}
	
	public List<LoanApplication> findAll(){
		
		return this.repo.findAll();
	}
	
	public List<LoanApplication> findAllSortedBy(String propName){
		
		return this.repo.findAll(Sort.by(propName));
	}
	
	public List<LoanApplication> findByPage(int page, int size, String propName){    
		
	    Pageable paging = 
	           PageRequest.of(page,size,Sort.by(propName).ascending());
	    
	    Page<LoanApplication> pagedResult = this.repo.findAll(paging);
	    
		if (pagedResult.hasContent()) {

			return pagedResult.getContent();

		} else {

			return new ArrayList<LoanApplication>();
		}
	}


	
	public LoanApplication findById(int id) {
		
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Element with id "+id+" Not Found "));
	}

	public LoanApplication update(LoanApplication entity) {
		return save(entity);
	}
	
	public LoanApplication remove(int id) {
		
		   LoanApplication toDelete = this.findById(id);
		   
			if (toDelete != null) {

				this.repo.deleteById(id);

			} else {
				toDelete = null;
			}

			   return toDelete;
	}
}

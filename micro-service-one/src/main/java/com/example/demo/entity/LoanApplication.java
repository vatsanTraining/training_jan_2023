package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component

@Entity
@Table(name = "bajaj_loan_master")
public class LoanApplication {

	@Id
	@Column(name = "application_number")
	int applicationNumber;
	
	@Column(name = "customer_name")
	String customerName;
	
	@Column(name = "loan_amount")
	double loanAmount;
	
	@Column(name = "pan_number")
	String panNumber;
	
}

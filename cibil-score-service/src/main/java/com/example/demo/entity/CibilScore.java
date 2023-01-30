package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bajaj_cibil")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CibilScore {

	@Id
	@Column(name = "pan_number")
	String panNumber;
	@Column(name = "score")
	double score;
}

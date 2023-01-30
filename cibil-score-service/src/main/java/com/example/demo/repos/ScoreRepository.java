package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CibilScore;

public interface ScoreRepository extends JpaRepository<CibilScore, String> {

}

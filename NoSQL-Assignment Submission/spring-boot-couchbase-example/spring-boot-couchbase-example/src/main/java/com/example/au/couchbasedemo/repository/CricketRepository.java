package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Cricket;

public interface CricketRepository extends CrudRepository<Cricket, String> {
	
	   
}
package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	Employee findByLocation(String location);
	
	Employee findByPincode(String pincode);

	//List deleteBytopicAndAuthor(String title, String author);
	   
}
package com.example.au.couchbasedemo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricket {
    
    @Id
    String id;
    
    @NotNull
    @Field
    private String name;
    
    @NotNull
    @Field
    private Integer average;
    
    @Field
    private Integer noOfRuns;
    
    @Field
    private Integer noOfWickets;
    
	public Cricket(String id, String name, Integer average, Integer noOfRuns, Integer noOfWickets ) {
		super();
		this.id = id;
		this.name = name;
		this.average = average;
		this.noOfRuns = noOfRuns;
		this.noOfWickets = noOfWickets;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAverage() {
		return average;
	}
	
	public void setAverage(Integer average) {
		this.average = average;
	}
	
	public Integer getNoOfRuns() {
		return noOfRuns;
	}
	
	public void setNoOfRuns(Integer noOfRuns) {
		this.noOfRuns = noOfRuns;
	}
	
	public Integer getNoOfWickets() {
		return noOfWickets;
	}
	
	public void setNoOfWickets(Integer noOfWickets) {
		this.noOfWickets = noOfWickets;
	}

    
    
    
}
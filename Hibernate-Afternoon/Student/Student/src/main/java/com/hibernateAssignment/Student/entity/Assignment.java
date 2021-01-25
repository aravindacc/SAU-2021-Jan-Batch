package com.hibernateAssignment.Student.entity;

import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.*;

@Entity
public class Assignment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AssignmentId;
	
	@Column 
	private String content;
	
	@Column 
	private Date endDate;
	
	@OneToOne
	private Student student;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}

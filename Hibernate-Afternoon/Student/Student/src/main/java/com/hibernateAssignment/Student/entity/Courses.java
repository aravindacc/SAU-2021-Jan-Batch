package com.hibernateAssignment.Student.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column
	private String courseName;
	
	@Column
	private String trainer;
	
    @ManyToMany(mappedBy = "courses")
    Set<Student> student;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(String courseName, String trainer) {
		super();
		this.courseName = courseName;
		this.trainer=trainer;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
    
}

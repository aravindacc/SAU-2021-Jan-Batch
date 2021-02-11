package com.hibernateAssignment.Student.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column
  	private Integer age;
	
	@Column
  	private String gender;
	
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Assignment assgnmt;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<Courses> courses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Assignment getAssgnmt() {
		return assgnmt;
	}

	public void setAssgnmt(Assignment assgnmt) {
		this.assgnmt = assgnmt;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, Integer age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
    
    
}

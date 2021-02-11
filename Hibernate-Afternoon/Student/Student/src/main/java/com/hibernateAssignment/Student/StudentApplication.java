package com.hibernateAssignment.Student;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernateAssignment.Student.repository.StudentJPARepository;
import com.hibernateAssignment.Student.repository.StudentRepository;
import com.hibernateAssignment.Student.entity.*;

//implements CommandLineRunner
@SpringBootApplication
public class StudentApplication implements CommandLineRunner{

	 @Resource
	 StudentRepository studentRepository;
	 
	 @Autowired
	 StudentJPARepository studentJPARepository;
	 
	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(StudentApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception{
		Assignment assignment1 = new Assignment();
		assignment1.setContent("React Native Assignment");
		assignment1.setEndDate(new Date(System.currentTimeMillis()));
		
		Assignment assignment2 = new Assignment();
		assignment2.setContent("Hibernate Assignment");
		assignment2.setEndDate(new Date(System.currentTimeMillis()));
		
		Courses course1 = new Courses();
		course1.setCourseName("React Native");
		course1.setTrainer("Tajammul Pasha");
		Courses course2 = new Courses();
		course2.setCourseName("Hibernate");
		course2.setTrainer("Santhosh Kalisamy");
		Courses course3 = new Courses();
		course3.setCourseName("Angular");
		course3.setTrainer("Sharanya Mahesheka");
		Courses course4 = new Courses();
		course4.setCourseName("Java");
		course4.setTrainer("Vinuta Gatate");
		Set<Courses> courseSet1 = new HashSet<>();
		Set<Courses> courseSet2 = new HashSet<>();
        courseSet1.add(course1);
        courseSet2.add(course2);
        courseSet1.add(course3);
        courseSet2.add(course4);
        
        Student student = new Student();
        student.setFirstName("Akshat");
        student.setLastName("Mehta");
        student.setAge(21);
        student.setGender("Male");
        student.setAssgnmt(assignment1);
        student.setCourses(courseSet1);
        Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student);
		
        Student student2 = new Student();
        student2.setFirstName("Virat");
        student2.setLastName("Pandya");
        student2.setAge(23);
        student2.setGender("Male");
        student2.setAssgnmt(assignment2);
        student2.setCourses(courseSet2);
        Set<Student> studentSet2 = new HashSet<Student>();
		studentSet2.add(student2);
		
//		studentRepository.addStudent(student);
//		studentRepository.addStudent(student2);		
//		studentJPARepository.save(student);
		
		
		List<Student> males = studentJPARepository.findStudentsByGender("Male");
		System.out.println("Find students by Gender(Male)");
		System.out.println(males);
		for(Student st:males) {
			System.out.println(st.getFirstName()+" "+st.getLastName());
		}
		List<Student> females = studentJPARepository.findStudentsByGender("Female");
		System.out.println("Find students by Gender(Female)");
		System.out.println(females);
		for(Student st:females) {
			System.out.println(st.getFirstName()+" "+st.getLastName());
		}
		// select * from student;
		List<Student> res = (List<Student>) studentJPARepository.findAll();
		for(Student st:res) {
			System.out.println(st.getFirstName()+" "+st.getLastName()+" is "+st.getAge()+" years old and the gender is "+st.getGender());
		}
	}

}

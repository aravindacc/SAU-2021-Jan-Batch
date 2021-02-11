package com.hibernateAssignment.Student.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.hibernateAssignment.Student.entity.Student;

public interface StudentJPARepository extends CrudRepository<Student,Integer>{
	public List<Student> findStudentsByGender(String gender);
}

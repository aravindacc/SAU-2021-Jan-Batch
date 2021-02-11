package com.hibernateAssignment.Student.repository;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.hibernateAssignment.Student.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@PersistenceContext
    EntityManager entityManager;

    public void addStudent(Student student){
        entityManager.persist(student);
    }

    public Student getStudentById(int id){
        return entityManager.find(Student.class, id);
    }

    public void deleteStudent(Student student){
        entityManager.remove(student);
    }

    public Student updateStudent(Student student){
        return entityManager.merge(student);
    }
    
}


    
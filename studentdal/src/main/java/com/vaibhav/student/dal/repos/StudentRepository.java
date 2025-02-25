package com.vaibhav.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.vaibhav.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	
}

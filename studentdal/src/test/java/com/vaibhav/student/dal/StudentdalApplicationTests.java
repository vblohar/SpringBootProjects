package com.vaibhav.student.dal;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vaibhav.student.dal.entities.Student;
import com.vaibhav.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("John");
		student.setCourse("Java");
		student.setFee(30d);
				
		studentRepository.save(student); 
	}
	
	@Test
	public void testFindStudentById() {
		Optional<Student> student =  studentRepository.findById(1L);
		System.out.println(student);
	}
	
	@Test
	public void testUpdateStudent() {
		Optional<Student> stud= studentRepository.findById(3L);
		
		Student student = stud.get();
			student.setFee(50d);
			studentRepository.save(student);
			System.out.println(student);
	}
	
	@Test
	public void testDeleteStudent() {
//		studentRepository.deleteById(1L);
		Student student = new Student();
		student.setId(2L);
		
		studentRepository.delete(student);
	}

}

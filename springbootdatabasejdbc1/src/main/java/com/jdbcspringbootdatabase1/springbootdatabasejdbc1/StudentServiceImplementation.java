package com.jdbcspringbootdatabase1.springbootdatabasejdbc1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcspringbootdatabase1.springbootdatabasejdbc1.models.Student;
import com.jdbcspringbootdatabase1.springbootdatabasejdbc1.repo.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImplementation {
	@Autowired
	StudentRepository studentRepository;
	public List<Student> getAllStudents(){
		return (List<Student>) studentRepository.findAll();	
	}
	public Student getStudentByID(int id) {
		return studentRepository.findById(id).get();	
	}
	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		
	}
	

}

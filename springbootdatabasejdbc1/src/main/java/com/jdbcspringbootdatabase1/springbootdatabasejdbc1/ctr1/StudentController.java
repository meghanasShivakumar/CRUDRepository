package com.jdbcspringbootdatabase1.springbootdatabasejdbc1.ctr1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcspringbootdatabase1.springbootdatabasejdbc1.StudentServiceImplementation;
import com.jdbcspringbootdatabase1.springbootdatabasejdbc1.models.Student;
@RestController
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	StudentServiceImplementation studentService;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Student> list() {
     List<Student>studentList=studentService.getAllStudents();
     return studentList;
}
	@RequestMapping(value="/getById/{id}",method=RequestMethod.GET)
	public Student editStudent(@PathVariable int id) {
	Student student=studentService.getStudentByID(id);
	return student;
	}
	
	@RequestMapping(value="/addStudent", method=RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody Student student) {
		studentService.addStudent(student);
		return "saved";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.PUT)
	public String edit(@PathVariable int id,@RequestBody Student student) {
		Student studentEdit=studentService.getStudentByID(id);
		studentEdit.setId(id);
		studentEdit.setFirstname(student.getFirstname());
		studentEdit.setLastname(student.getLastname());
		studentService.addStudent(studentEdit);
		return "edited";
	}
	@RequestMapping(value="/deleteStudent/{id}", method=RequestMethod.DELETE)
public String delete(@PathVariable("id")int id) {
	studentService.deleteStudent(id);
	return "deleted";
      }
          
	
		
	}
		
	
package com.example.demo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping("/")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("/not-first-name/{name}")
	public List<Student> getAllStudentNotFirstName(@PathVariable String name){
		return this.studentService.getAllStudentsNotFirstName(name);
	}
			
			
	@GetMapping("/id/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = studentService.getStudentById(id);
		if(student !=null) {
			return ResponseEntity.ok(student);
		}
		else {
			return ResponseEntity.notFound().build();

		}
	}
		
	@GetMapping("/name/{name}")
	public List<Student> getStudenByName(@PathVariable String name) {
		return studentService.getByName(name);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		student.setId(0);
		student = studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		Student existstudent = studentService.getStudentById(id);
		System.out.println(existstudent.toString());
		if(existstudent.toString() != null) {
			existstudent.setFirstName(student.getFirstName());
			existstudent.setLastName(student.getLastName());
			existstudent.setEmail(student.getEmail());
			studentService.updateStudent(existstudent);
			return ResponseEntity.ok(existstudent);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id){
		Student exStudent = new Student();
		exStudent = studentService.getStudentById(id);
		
		System.out.println(exStudent);
		if(exStudent != null) {
			studentService.deleteStudent(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
}

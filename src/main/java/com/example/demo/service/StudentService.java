package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public Student getStudentById(int id);
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(int id);
	public List<Student> getByName(String name);
	
	public List<Student> getAllStudentsNotFirstName(String name);
}
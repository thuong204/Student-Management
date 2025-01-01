package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.saveAndFlush(student);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentsNotFirstName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameNot(name);
	}
}

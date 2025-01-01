package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.Student;

@RepositoryRestController
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);
//	public List<Student> findByFirstNameandLastName(String firstName, String lastName);
//	
	@Query("SELECT s FROM Student s WHERE s.firstName <> ?1")
	public List<Student> findByFirstNameNot(String firstName);
//	

}





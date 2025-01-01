//package com.example.demo.dao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.entity.Student;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//import jakarta.persistence.TypedQuery;
//
//@Repository
//public class StudentImp implements StudentDao{
//	private EntityManager entityManager;
//	
//	@Autowired
//	public StudentImp(EntityManager entityManager) {
//		this.entityManager=entityManager;
//	}
//
//	@Override
//	public List<Student> getByName(String name) {
//		String jpql = "SELECT s FROM Student s WHERE s.student_lastname = :t";
//		TypedQuery<Student> query= this.entityManager.createQuery(jpql,Student.class); 
//		query.setParameter("t", name);
//		return query.getResultList();
//	}
//
//	@Override
//	public List<Student> findAll() {
//		// TODO Auto-generated method stub
//		String jpql = "SELECT s FROM Student s ";
//		return entityManager.createQuery(jpql,Student.class).getResultList();
//	}
//
//	@Override
//	public Student addStudent(Student student) {
//		// TODO Auto-generated method stub
//		entityManager.persist(student);
//		return student;
//	}
//
//	@Override
//	public Student updateStudent(Student student) {
//		// TODO Auto-generated method stub
//		student =entityManager.merge(student);
//		entityManager.flush();
//		return student;
//		
//	}
//
//	@Override
//	public void deletedStudent(int id) {
//		// TODO Auto-generated method stub
//		Student std = entityManager.find(Student.class, id);
//		entityManager.remove(std);
//	}
//
//	@Override
//	public Student getById(int id) {
//		return this.entityManager.find(Student.class, id);
//	}
//
//}

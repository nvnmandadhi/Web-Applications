package com.naveen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.naveen.dao.StudentDao;
import com.naveen.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	@Override
	public List<Student> findAll() {
		return entityManager.createQuery("select s from Student s", Student.class).getResultList();
	}

	@Override
	public Student findOne(long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public void deleteStudent(long id) {
		entityManager.remove(entityManager.find(Student.class, id));
	}

	@Override
	public void saveStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void updateStudent(Student s) {
		Student student = entityManager.find(Student.class, s.getId());
		student.setName(s.getName());
		student.setEmail(s.getEmail());
		entityManager.persist(student);
	}

}

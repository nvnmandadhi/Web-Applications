/**
 * 
 */
package com.naveen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.naveen.dao.StudentDao;
import com.naveen.model.Student;

/**
 * @author Naveen
 *
 */

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public int save(Student student) {
	student.setRole("ROLE_USER");
	student.setPassword(passwordEncoder.encode(student.getPassword()));
	entityManager.persist(student);
	return 1;
    }

    @Override
    public void deleteStudentById(int id) {
	Student student = entityManager.find(Student.class, id);
	entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
	List<Student> list = entityManager.createQuery("select s from Student s", Student.class).getResultList();
	return list;
    }

    @Override
    public List<Student> findByUserName(String username) {

	Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.username= ?1", Student.class);
	query.setParameter(1, username);

	@SuppressWarnings("unchecked")
	List<Student> user = query.getResultList();

	if (user.isEmpty()) {
	    return null;
	} else {
	    return user;
	}
    }

}

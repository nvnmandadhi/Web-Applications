package com.naveen.dao;

import java.util.List;

import com.naveen.model.Student;

public interface StudentDao {

	List<Student> findAll();

	Student findOne(long id);

	void deleteStudent(long id);
	
	void saveStudent(Student student);
	
	void updateStudent(Student s);

}

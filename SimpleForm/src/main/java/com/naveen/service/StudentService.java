package com.naveen.service;

import java.util.List;

import com.naveen.model.Student;

public interface StudentService {

	List<Student> getStudentsList();

	void addStudent(Student s);

	void updateStudent(Student p);

	void removeStudent(long id);

	Student getStudentById(long id);
}

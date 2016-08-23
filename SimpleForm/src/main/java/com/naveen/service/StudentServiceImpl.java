package com.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.naveen.dao.StudentDao;
import com.naveen.model.Student;

@Service
@Transactional
@EnableTransactionManagement
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getStudentsList() {

		return studentDao.findAll();

	}

	@Override
	public void addStudent(Student s) {
		studentDao.saveStudent(s);
	}

	@Override
	public void updateStudent(Student p) {
		studentDao.updateStudent(p);
	}

	@Override
	public void removeStudent(long id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public Student getStudentById(long id) {
		return studentDao.findOne(id);
	}

}

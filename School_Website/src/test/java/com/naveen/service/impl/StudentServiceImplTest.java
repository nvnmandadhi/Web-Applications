package com.naveen.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.naveen.AbstractTest;
import com.naveen.dao.StudentDao;
import com.naveen.model.Student;
import com.naveen.service.StudentService;

public class StudentServiceImplTest extends AbstractTest {

    @Autowired
    private StudentService studentService;

    @Mock
    StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStudent() {
	Student student = new Student();

	when(studentDao.save(student)).thenReturn(new Integer(1));

	boolean result = studentService.addStudent(student);

	assertTrue(result);
    }

    @Test
    public void testDeleteStudentById() {
	fail("Not yet implemented");
    }

    @Test
    public void testFindAll() {
	fail("Not yet implemented");
    }

    @Test
    public void testLoadUserByUsername() {
	fail("Not yet implemented");
    }

}

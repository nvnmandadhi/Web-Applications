/**
 * 
 */
package com.naveen.service;

import java.util.List;

import com.naveen.model.Student;

/**
 * @author Naveen
 *
 */
public interface StudentService {

    boolean addStudent(Student student);

    boolean deleteStudentById(int id);

    List<Student> findAll();

}

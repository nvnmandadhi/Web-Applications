/**
 * 
 */
package com.naveen.dao;

import java.util.List;

import com.naveen.model.Student;

/**
 * @author Naveen
 *
 */

public interface StudentDao {

    int save(Student student);

    void deleteStudentById(int id);

    List<Student> findAll();

    List<Student> findByUserName(String username);

}

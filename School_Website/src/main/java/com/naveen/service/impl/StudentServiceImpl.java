/**
 * 
 */
package com.naveen.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.naveen.dao.StudentDao;
import com.naveen.model.Student;
import com.naveen.service.StudentService;

/**
 * @author Naveen
 *
 */

@EnableTransactionManagement
@Transactional
@Service
public class StudentServiceImpl implements StudentService, UserDetailsService {

    @Autowired
    StudentDao studentDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.naveen.service.StudentService#addStudent(com.naveen.model.Student)
     */

    @Override
    public boolean addStudent(Student student) {

	studentDao.save(student);

	return true;
    }

    @Override
    public boolean deleteStudentById(int id) {

	studentDao.deleteStudentById(id);

	return true;
    }

    @Override
    public List<Student> findAll() {

	List<Student> list = studentDao.findAll();
	return list;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	List<Student> user = studentDao.findByUserName(username);

	List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.get(0).getRole());

	String password = user.get(0).getPassword();

	return new User(username, password, auth);
    }

}

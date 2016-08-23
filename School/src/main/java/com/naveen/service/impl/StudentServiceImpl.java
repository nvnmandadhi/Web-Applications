/**
 * 
 */
package com.naveen.service.impl;

import org.springframework.stereotype.Service;

import com.naveen.service.StudentService;

/**
 * @author Naveen
 *
 */

@Service
public class StudentServiceImpl implements StudentService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.naveen.service.StudentService#authenticateUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean authenticateUser(String username, String password) {

		if (username.equals("admin") && password.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

}

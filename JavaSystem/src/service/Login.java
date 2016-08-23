package service;

import models.LoginBean;

public interface Login {

	public boolean authenticateUser(LoginBean newlogin);
}

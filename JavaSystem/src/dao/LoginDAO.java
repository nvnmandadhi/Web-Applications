package dao;

import models.LoginBean;

public interface LoginDAO {

	boolean isAuthorized(LoginBean newlogin);
}

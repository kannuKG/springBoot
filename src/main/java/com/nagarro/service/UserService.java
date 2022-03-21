package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.model.Users;

@Service
public class UserService {

	@Autowired
	UserDao loginDao;
	public boolean validation(String u,String p) {
		return loginDao.check(u, p);
	}
	public void save(){
		Users u=new Users();
		u.setUsername("kanishk");
		u.setPassword("kanishk123");
		loginDao.saveData(u);
	}
}

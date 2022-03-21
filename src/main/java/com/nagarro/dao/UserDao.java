package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.Users;

@Component
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean check(String u,String p) {
		Transaction t=null;
		try {
		Session session=sessionFactory.openSession();
		t=session.beginTransaction();
		Users user=(Users)session.createQuery("from Users where username=:u").setParameter("u",u).uniqueResult();
		t.commit();
		if(user!=null && user.getPassword().equals(p)) {
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e) {
			if(t!=null) {
				t.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	public void saveData(Users u) {
		Transaction t=null;
		try{
		Session session=sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(u);
		t.commit();
		session.close();
		}
		catch(Exception e) {
			if(t!=null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}
}

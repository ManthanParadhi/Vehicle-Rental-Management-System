package com.shashank.vrms.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.shashank.vrms.enums.*;
import com.shashank.vrms.models.User;
import com.shashank.vrms.models.UserDetails;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.utilities.BCrypt;
import com.shashank.vrms.utilities.Helper;
import com.shashank.vrms.utilities.HibernateUtil;

public class UserDAO {

	public void registerUser(User user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

	public boolean isEmailAlreadyTaken(User user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		User userFromDb = (User) criteria.add(Restrictions.eq("email", user.getEmail()))
		                             .uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		if(userFromDb != null)
			return true;
		return false;
	}

	public boolean checkCredentials(String email, String password)  {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		User userFromDb = (User) criteria.add(Restrictions.eq("email", email))
		                             .uniqueResult();
		session.getTransaction().commit();
		session.close();
		System.out.println(userFromDb.getPassword().toString());
		boolean matched = BCrypt.checkpw(password, userFromDb.getPassword());
		System.out.println(matched);
		return matched;
	}
	
	public User getUserByEmailId(String email) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		User userFromDb = (User) criteria.add(Restrictions.eq("email", email))
		                             .uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return userFromDb;
	}

		

	public List<User> getAllUsers() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> userList = criteria.add(Restrictions.eq("role", Role.CUSTOMER)).list();
                
		session.getTransaction().commit();
		session.close();		
		return userList;

	}
	
	public void updateUser(User user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();

	}
}

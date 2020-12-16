package com.semanticsqare.thrillo.manager;

import com.semanticsqare.thrillo.dao.UserDao;
import com.semanticsqare.thrillo.entites.User;

public class UserManager {
	private static UserManager instance=new UserManager();
	public static UserDao dao=new UserDao();
	private UserManager() {}
	
	public static UserManager getInstance() {
		return instance;
		
	}
	public User createUser(long id,String Email, String password, String FirstName, String LastName, int Gender, String UserType)
	{
		User user=new User();
		user.setId(id);
		user.setEmail(Email);
		user.setPassword(password);
		user.setFirstName(FirstName);
		user.setLastName(LastName);
		user.setGender(Gender);
		user.setUserType(UserType);
		
		
		return user;
		
	}
	public User[] getUsers() {
		return dao.getUsers();
	}

}

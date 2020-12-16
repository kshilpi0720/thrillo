package com.semanticsqare.thrillo.dao;

import com.semanticsqare.thrillo.DataStore;
import com.semanticsqare.thrillo.entites.User;

public class UserDao {
	public User[]  getUsers(){
	return DataStore.getUsers();	
	}

}

package org.dao;

import org.entities.User;

public interface UserDao {
	
	void insert(User user);
	User get(String username,String password);
	void update(User user);

}

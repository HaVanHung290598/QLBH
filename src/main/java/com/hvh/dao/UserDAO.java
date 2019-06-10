package com.hvh.dao;

import com.hvh.entity.User;

public interface UserDAO {
	public void addUser(User user);
	public User getUserById(int user_id);
	public User getUserByUsername(String username);
}

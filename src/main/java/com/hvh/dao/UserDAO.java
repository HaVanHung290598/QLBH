package com.hvh.dao;

import java.util.List;

import com.hvh.entity.User;

public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int user_id);
	public User getUserByUsername(String username);
	public List<User> getListUser(int page, int limit);
	public List<User> searchUser(String username, int page, int limit);
}

package com.hvh.service;

import com.hvh.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	public UserDTO getUserById(int user_id);
	public UserDTO getUserByUsername(String username);
}

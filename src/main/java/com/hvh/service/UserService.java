package com.hvh.service;

import java.util.List;
import java.util.Map;

import com.hvh.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	public void deleteUser(int id);
	public UserDTO getUserById(int user_id);
	public UserDTO getUserByUsername(String username);
	public List<UserDTO> getListUser(int page, int limit);
	public void updateUser(UserDTO userDTO);
	public List<UserDTO> searchUser(String username, int page, int limit);
	public Boolean getUserByInforUser(String username, String phone, String email);
	public List<UserDTO> searchUser(Map<String, String> params, int page, int limit);
}

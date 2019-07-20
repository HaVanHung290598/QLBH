package com.hvh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hvh.dao.UserDAO;
import com.hvh.entity.User;
import com.hvh.model.UserDTO;
import com.hvh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public UserDTO getUserById(int user_id) {
		User user = userDAO.getUserById(user_id);
		return convert(user);
	}

	@Override
	public void addUser(UserDTO userDTO) {
		userDAO.addUser(convert(userDTO));
	}

	@Override
	public UserDTO getUserByUsername(String username) {
		User user = userDAO.getUserByUsername(username);
		return convert(user);
	}
	
	private UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setFullname(user.getFullname());
		userDTO.setAddress(user.getAddress());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setCreated_at(user.getCreated_at());
		userDTO.setUpdated_at(user.getUpdated_at());
		userDTO.setRole(user.getRole());
		userDTO.setEnabled(user.getEnabled());
		return userDTO;
	}
	private User convert(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setFullname(userDTO.getFullname());
		user.setAddress(userDTO.getAddress());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		user.setCreated_at(userDTO.getCreated_at());
		user.setUpdated_at(userDTO.getUpdated_at());
		user.setRole(userDTO.getRole());
		user.setEnabled(userDTO.getEnabled());
		return user;
	}

	@Override
	public List<UserDTO> getListUser(int page, int limit) {
		List<User> users = userDAO.getListUser(page, limit);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(User user : users) {
			userDTOs.add(convert(user));
		}
		return userDTOs;
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		userDAO.updateUser(convert(userDTO));
	}

	@Override
	public List<UserDTO> searchUser(String username, int page, int limit) {
		List<User> users = userDAO.searchUser(username, page, limit);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(User user : users) {
			userDTOs.add(convert(user));
		}
		return userDTOs;
	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}

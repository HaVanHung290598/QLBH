package com.hvh.service.impl;

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
		return userDTO;
	}
	
}

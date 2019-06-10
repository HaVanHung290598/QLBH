package com.hvh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hvh.model.UserDTO;
import com.hvh.service.UserService;

@Controller
public class LoginController {
	long millis = System.currentTimeMillis();
	java.util.Date created_at = new java.util.Date(millis);
	java.util.Date updated_at = new java.util.Date(millis);
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(req, resp, authentication);
		}
		return "redirect:/home";
	}
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "signUp";
	}

	@RequestMapping(value="singUp", method = RequestMethod.POST)
	public String singUp(HttpServletRequest req, HttpServletResponse resp) {
		String fullname = req.getParameter("fullname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phonenumber");
		String username = req.getParameter("username");
		String password = bCryptPasswordEncoder.encode(req.getParameter("password"));
		String email = req.getParameter("email");
		String role = "ROLE_USER";
		int enabled = 1;
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		userDTO.setFullname(fullname);
		userDTO.setAddress(address);
		userDTO.setPhone(phone);
		userDTO.setEmail(email);
		userDTO.setCreated_at(created_at);
		userDTO.setUpdated_at(updated_at);
		userDTO.setRole(role);
		userDTO.setEnabled(enabled);
		userService.addUser(userDTO);
		return "redirect:/login";
	}
}

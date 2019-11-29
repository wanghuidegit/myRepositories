package com.bjsxt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userServic;
	@RequestMapping("/consumer")
	public List<User> getUsers(){
		return this.userServic.getUsers();
	}
}

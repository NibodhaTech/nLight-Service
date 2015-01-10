package com.nibodha.lgaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibodha.lgaas.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/getkey/{username}")
	public String checkUser(@PathVariable("username") String username){
		String apikey = userService.getActivattionKey(username);
		System.out.println("Check User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/setkey/{username}")
	public String addUser(@PathVariable("username") String username){
		String apikey = userService.addUser(username);
		System.out.println("Add User "+apikey);
		return apikey;
	}
	
	

}

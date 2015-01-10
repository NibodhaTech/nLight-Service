package com.nibodha.lgaas.service;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibodha.lgaas.dao.UserDao;
import com.nibodha.lgaas.entity.User;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	private SecureRandom random = new SecureRandom();
	
	public String getActivattionKey(String username){
		String apiKey;
		User user = userDao.findOneByUname(username);
		if(user != null){
			apiKey = user.getApikey();
		}else{
			apiKey = "nokey";
		}
		return apiKey;	
	}

	public String addUser(String username) {
		// TODO Auto-generated method stub
		String apiKey = new BigInteger(130, random).toString(32);
		User user = new User();
		user.setApikey(apiKey);
		user.setUname(username);
		user.setUserSource("facebook");
		userDao.save(user);
		return apiKey;
	}

}

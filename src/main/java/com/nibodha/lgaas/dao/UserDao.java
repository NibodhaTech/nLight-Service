package com.nibodha.lgaas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibodha.lgaas.entity.User;

public interface UserDao  extends JpaRepository<User, Long>  {

	public User findOneByUname(String name);
}

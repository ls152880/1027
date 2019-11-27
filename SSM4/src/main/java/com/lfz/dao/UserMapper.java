package com.lfz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lfz.entity.User;

@Repository
public interface UserMapper {

	public List<User> findUserAll();

	public User findUserByUserName(String userName);
}

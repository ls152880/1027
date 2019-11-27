package com.lfz.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lfz.entity.User;

public interface UserService {

	public List<User> findUserAll();

	public PageInfo<User> findUserByPage(int pageNum, int PageSize);

	/*
	 * 通过账号查询用户
	 */
	public User findUserByUserName(String userName);
}

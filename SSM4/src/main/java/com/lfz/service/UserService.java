package com.lfz.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lfz.entity.User;

public interface UserService {

	public List<User> findUserAll();

	public PageInfo<User> findUserByPage(int pageNum, int PageSize);

	/*
	 * ͨ���˺Ų�ѯ�û�
	 */
	public User findUserByUserName(String userName);
}

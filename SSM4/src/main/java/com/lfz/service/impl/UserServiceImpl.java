package com.lfz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfz.dao.UserMapper;
import com.lfz.entity.User;
import com.lfz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;

	@Override
	public List<User> findUserAll() {
		List<User> users = um.findUserAll();
		return users;
	}

	@Override
	public PageInfo<User> findUserByPage(int pageNum, int pageSize) {
		// 创建PageHelper对象
		PageHelper ph = new PageHelper();
		// 调用startPage方法开始分页
		ph.startPage(pageNum, pageSize);
		// 从serMapper接口中调用方法，查询数据
		List<User> users = um.findUserAll();
		// 将查询出的结果集放到PageInfo里面
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}

	/*
	 * 通过账号查询用户
	 */
	@Override
	public User findUserByUserName(String userName) {
		User u = um.findUserByUserName(userName);
		return u;
	}

}

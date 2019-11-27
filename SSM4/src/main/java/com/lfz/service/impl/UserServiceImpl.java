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
		// ����PageHelper����
		PageHelper ph = new PageHelper();
		// ����startPage������ʼ��ҳ
		ph.startPage(pageNum, pageSize);
		// ��serMapper�ӿ��е��÷�������ѯ����
		List<User> users = um.findUserAll();
		// ����ѯ���Ľ�����ŵ�PageInfo����
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}

	/*
	 * ͨ���˺Ų�ѯ�û�
	 */
	@Override
	public User findUserByUserName(String userName) {
		User u = um.findUserByUserName(userName);
		return u;
	}

}

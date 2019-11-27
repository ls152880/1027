package com.lfz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lfz.entity.User;
import com.lfz.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	@ResponseBody
	public List<User> findUser() {
		List<User> users = us.findUserAll();
		return users;
	}

	@RequestMapping(value = "/findUserByPage", method = RequestMethod.POST)
	@ResponseBody
	public List<User> findUser1() {
		PageInfo<User> page = us.findUserByPage(2, 3);
		return page.getList();
	}

}

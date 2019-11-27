package com.lfz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfz.dao.MenuMapper;
import com.lfz.entity.Menu;
import com.lfz.service.MenuService;

/*
 * 查询所有权限
 * */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper mm;

	@Override
	public List<Menu> findMenuAll() {
		List<Menu> menus = mm.findMenuAll();
		return menus;
	}

}

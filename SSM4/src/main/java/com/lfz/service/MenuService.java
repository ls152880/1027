package com.lfz.service;

import java.util.List;

import com.lfz.entity.Menu;

public interface MenuService {
	/**
	 * 查询所有权限
	 */
	public List<Menu> findMenuAll();
}

package com.lfz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lfz.entity.Menu;

@Repository
public interface MenuMapper {
	public List<Menu> findMenuAll();
}

package com.lfz.controller;

import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfz.facotry.MyShiroFilterFactoryBean;

@Controller

@RequestMapping("/user")
public class StuAndTeaController {

	@Autowired
	private MyShiroFilterFactoryBean myShiroFilterFactoryBean;

	@RequestMapping("/query/studentScore")
	public String queryStuScore() {
		return "stuScore";
	}

	@RequestMapping("/add/studentScore")
	public String addStuScore() {
		return "addStuScore";
	}

	@RequestMapping("/update/studentScore")
	public String updateStuScore() {
		return "updateStuScore";
	}

	@RequestMapping("/query/classroom")
	public String queryClassroom() {
		return "classroom";
	}

	@RequestMapping("/add/teacher")
	public String addTeacher() {
		return "addTeacher";
	}

	@RequestMapping("/query/studentall")
	public String querystudentall() {
		return "studentall";
	}

	/*
	 * @RequestMapping("/addAuth") public String addStu(Student stu){ //
	 * 修改权限代码 reloadFilterChains(); return "login"; }
	 */

	/**
	 * 动�?�更新新的权�?
	 * 
	 * @param filterMap
	 */
	public void reloadFilterChains() {
		synchronized (myShiroFilterFactoryBean) { // 强制同步，控制线程安�?
			AbstractShiroFilter shiroFilter = null;

			try {
				shiroFilter = (AbstractShiroFilter) myShiroFilterFactoryBean.getObject();

				PathMatchingFilterChainResolver resolver = (PathMatchingFilterChainResolver) shiroFilter
						.getFilterChainResolver();
				// 过滤管理�?
				DefaultFilterChainManager manager = (DefaultFilterChainManager) resolver.getFilterChainManager();
				// 清除权限配置
				manager.getFilterChains().clear();
				myShiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
				// 重新设置权限
				myShiroFilterFactoryBean.setFilterChainDefinitions(MyShiroFilterFactoryBean.filterChainDefinitions);// 传入配置中的filterchains

				Map<String, String> chains = myShiroFilterFactoryBean.getFilterChainDefinitionMap();
				// 重新生成过滤�?
				if (!CollectionUtils.isEmpty(chains)) {
					for (Map.Entry<String, String> chain : chains.entrySet()) {
						manager.createChain(chain.getKey(), chain.getValue().replace(" ", ""));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

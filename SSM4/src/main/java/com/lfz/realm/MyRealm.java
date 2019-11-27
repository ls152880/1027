package com.lfz.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lfz.entity.Role;
import com.lfz.entity.User;
import com.lfz.service.UserService;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	/**
	 * 
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 1. 从PrincipalCollection中来获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();
		System.out.println("当前登陆的用户:" + principal);
		// 2. 利用登录的用户信息来获取当前用户角色以及权限（可能查询数据库）

		Set<String> set = new HashSet<String>();
		// set.add("lye");
		// 查询user通过账号
		User user = userService.findUserByUserName((String) principal);
		// 得到user对应的角色
		Role role = user.getRole();
		// 角色名放入set中
		set.add(role.getRolename());
		/*
		 * User user = userService.findUser((String) principal);
		 * System.out.println(user.getRoleList()); List<Role> roles =
		 * user.getRoleList(); for(Role role : roles){ set.add(role.getRname());
		 * System.out.println(role.getRname()); }
		 */

		System.out.println("set里的值:" + set);
		// 3. 创建SimpleAuthorizationInfo,并设置reles属性
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 给当前用户添加角色
		simpleAuthorizationInfo.addRoles(set);
		// 4. 返回SimpleAuthorizationInfo对象
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 从token中拿到username
		String userName = (String) token.getPrincipal();
		// 通过username去数据库里面查询
		User user = userService.findUserByUserName(userName);
		System.out.println(user);
		/*
		 * User user = userService.findUser(userName); System.out.println(user);
		 */

		Subject currentUser = SecurityUtils.getSubject();
		// 获取session
		Session session = currentUser.getSession();
		// 将登录账号放入session（作用域servlet中的session一样）
		session.setAttribute("username", user.getUserName());
		/*
		 * session.setAttribute("userName", userName);
		 * session.setAttribute("headImg", user.getHeadImg());
		 */
		// 获取严，通用账号
		ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
		// 严值加密，传入四个参数，：账号，密码，严，数据源的名字
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(),
				credentialsSalt, getName());
		// SimpleAuthenticationInfo simpleAuthenticationInfo = new
		// SimpleAuthenticationInfo(user,
		// "64c8b1e43d8ba3115ab40bcea57f010b",getName());
		return simpleAuthenticationInfo;
	}

}

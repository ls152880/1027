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
	 * ��Ȩ����
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 1. ��PrincipalCollection������ȡ��¼�û�����Ϣ
		Object principal = principals.getPrimaryPrincipal();
		System.out.println("��ǰ��½���û�:" + principal);
		// 2. ���õ�¼���û���Ϣ����ȡ��ǰ�û���ɫ�Լ�Ȩ�ޣ����ܲ�ѯ���ݿ⣩

		Set<String> set = new HashSet<String>();
		// set.add("lye");
		// ��ѯuserͨ���˺�
		User user = userService.findUserByUserName((String) principal);
		// �õ�user��Ӧ�Ľ�ɫ
		Role role = user.getRole();
		// ��ɫ������set��
		set.add(role.getRolename());
		/*
		 * User user = userService.findUser((String) principal);
		 * System.out.println(user.getRoleList()); List<Role> roles =
		 * user.getRoleList(); for(Role role : roles){ set.add(role.getRname());
		 * System.out.println(role.getRname()); }
		 */

		System.out.println("set���ֵ:" + set);
		// 3. ����SimpleAuthorizationInfo,������reles����
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// ����ǰ�û���ӽ�ɫ
		simpleAuthorizationInfo.addRoles(set);
		// 4. ����SimpleAuthorizationInfo����
		return simpleAuthorizationInfo;
	}

	/**
	 * ��֤����
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// ��token���õ�username
		String userName = (String) token.getPrincipal();
		// ͨ��usernameȥ���ݿ������ѯ
		User user = userService.findUserByUserName(userName);
		System.out.println(user);
		/*
		 * User user = userService.findUser(userName); System.out.println(user);
		 */

		Subject currentUser = SecurityUtils.getSubject();
		// ��ȡsession
		Session session = currentUser.getSession();
		// ����¼�˺ŷ���session��������servlet�е�sessionһ����
		session.setAttribute("username", user.getUserName());
		/*
		 * session.setAttribute("userName", userName);
		 * session.setAttribute("headImg", user.getHeadImg());
		 */
		// ��ȡ�ϣ�ͨ���˺�
		ByteSource credentialsSalt = ByteSource.Util.bytes(userName);
		// ��ֵ���ܣ������ĸ����������˺ţ����룬�ϣ�����Դ������
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(),
				credentialsSalt, getName());
		// SimpleAuthenticationInfo simpleAuthenticationInfo = new
		// SimpleAuthenticationInfo(user,
		// "64c8b1e43d8ba3115ab40bcea57f010b",getName());
		return simpleAuthenticationInfo;
	}

}

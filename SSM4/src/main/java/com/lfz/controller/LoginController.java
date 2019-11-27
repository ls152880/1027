package com.lfz.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	/**
	 * Ìø×ªµ½µÇÂ¼Ò³Ãæ
	 */
	@RequestMapping("/gologin")
	public String gologin() {
		return "login";
	}

	/**
	 * ÍË³ö
	 */
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * µÇÂ¼
	 */
	@RequestMapping("/login")
	public String login(String username, String password, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			return "redirect:main";
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getSession().setAttribute("error", "ÕËºÅ»òÃÜÂë´íÎó");
			return "login";
		}

	}
}

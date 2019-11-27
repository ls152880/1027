package com.lfz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfz.entity.Teacher;
import com.lfz.facotry.MyShiroFilterFactoryBean;
import com.lfz.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService ts;
	private MyShiroFilterFactoryBean myShiroFilterFactoryBean;

	// 查询所有教师信息
	@RequestMapping("/query/allTeacher")
	public String queryTeacherAll(HttpServletRequest request) {
		System.out.println("========================");
		List<Teacher> lt = ts.findTeacherAll();
		request.getSession().setAttribute("teas", lt);
		System.out.println(lt + "***********");
		return "teacherall";
	}
}

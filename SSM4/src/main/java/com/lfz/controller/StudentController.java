package com.lfz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfz.entity.Student;
import com.lfz.facotry.MyShiroFilterFactoryBean;
import com.lfz.service.StudentService;

@Controller
@RequestMapping("/teacher")
public class StudentController {

	@Autowired
	private StudentService ss;
	private MyShiroFilterFactoryBean myShiroFilterFactoryBean;

	// 查询所有教师信息
	@RequestMapping("/query/studentall")
	public String queryStudentAll(HttpServletRequest request) {
		System.out.println("========================");
		List<Student> lt = ss.findStudentAll();
		request.getSession().setAttribute("stu", lt);
		System.out.println(lt + "***********");
		return "studentall";
	}
}

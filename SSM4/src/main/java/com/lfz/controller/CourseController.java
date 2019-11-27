package com.lfz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfz.entity.Course;
import com.lfz.facotry.MyShiroFilterFactoryBean;
import com.lfz.service.CourseService;

@Controller
@RequestMapping("/user")
public class CourseController {

	@Autowired
	private CourseService cs;
	private MyShiroFilterFactoryBean myShiroFilterFactoryBean;

	@RequestMapping("/query/course")
	public String queryCourseAll(HttpServletRequest request) {
		System.out.println("========================");
		List<Course> lt = cs.findCourseAll();
		request.getSession().setAttribute("cou", lt);
		System.out.println(lt + "***********");
		return "course";
	}
}

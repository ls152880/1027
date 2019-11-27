package com.lfz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfz.dao.CourseMapper;
import com.lfz.entity.Course;
import com.lfz.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper cm;

	@Override
	public List<Course> findCourseAll() {
		List<Course> course = cm.findCourseAll();
		return course;
	}

}

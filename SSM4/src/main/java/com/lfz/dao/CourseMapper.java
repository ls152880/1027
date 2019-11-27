package com.lfz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lfz.entity.Course;

@Repository
public interface CourseMapper {

	public List<Course> findCourseAll();
}

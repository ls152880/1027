package com.lfz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lfz.entity.Teacher;

@Repository
public interface TeacherMapper {

	public List<Teacher> findTeacherAll();
}

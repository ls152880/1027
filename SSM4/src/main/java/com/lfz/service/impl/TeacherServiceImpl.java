package com.lfz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfz.dao.TeacherMapper;
import com.lfz.entity.Teacher;
import com.lfz.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper tm;

	@Override
	public List<Teacher> findTeacherAll() {
		List<Teacher> teacher = tm.findTeacherAll();
		return teacher;
	}

}

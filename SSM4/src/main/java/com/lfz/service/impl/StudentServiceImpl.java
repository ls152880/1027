package com.lfz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfz.dao.StudentMapper;
import com.lfz.entity.Student;
import com.lfz.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper sm;

	@Override
	public List<Student> findStudentAll() {

		List<Student> student = sm.findStudentAll();
		return student;
	}

}

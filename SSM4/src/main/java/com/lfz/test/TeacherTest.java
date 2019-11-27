package com.lfz.test;

import java.util.List;

import com.lfz.entity.Teacher;
import com.lfz.service.impl.TeacherServiceImpl;

public class TeacherTest {
	public static void main(String[] args) {
		TeacherServiceImpl ss = new TeacherServiceImpl();
		List<Teacher> list = ss.findTeacherAll();
		System.out.println(list);
	}
}

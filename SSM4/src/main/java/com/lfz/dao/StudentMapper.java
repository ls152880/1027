package com.lfz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lfz.entity.Student;

@Repository
public interface StudentMapper {

	public List<Student> findStudentAll();
}

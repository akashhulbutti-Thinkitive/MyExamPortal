package com.akash.dao;

import com.akash.models.Student;
import com.akash.models.Teacher;
import com.akash.models.Admin;

public interface AdminDao {
	public Admin saveUserAdmin(Admin admin);
	
	public Teacher saveUserTeacher(Teacher teacher);
	
	public Student saveUserStudent(Student student);

}

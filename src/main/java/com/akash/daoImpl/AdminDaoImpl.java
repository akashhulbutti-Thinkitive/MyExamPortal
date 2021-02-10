package com.akash.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.AdminDao;
import com.akash.models.Student;
import com.akash.models.Teacher;
import com.akash.models.Admin;
import com.akash.repository.StudentRepository;
import com.akash.repository.TeacherRepository;
import com.akash.repository.AdminRepository;

@Service
public class AdminDaoImpl implements AdminDao{
	
	@Autowired AdminRepository userRepository;
	@Autowired TeacherRepository teacherRepository;
	@Autowired StudentRepository studentRepository;

	@Override
	public Admin saveUserAdmin(Admin admin) {
		Admin savedAdmin = userRepository.save(admin);
		return savedAdmin;
	}

	@Override
	public Teacher saveUserTeacher(Teacher teacher) {
		Teacher savedTeacher = teacherRepository.save(teacher);
		return savedTeacher;
	}

	@Override
	public Student saveUserStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

}

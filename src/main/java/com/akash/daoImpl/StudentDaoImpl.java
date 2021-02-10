package com.akash.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.StudentDao;
import com.akash.models.Student;
import com.akash.repository.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao{
	
	@Autowired StudentRepository studentRepo;
	
	public Student getStudentByUser(Integer userId) {
		return studentRepo.getStudentByUser(userId);
	}

}

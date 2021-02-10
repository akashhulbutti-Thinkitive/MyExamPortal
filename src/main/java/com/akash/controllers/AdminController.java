package com.akash.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.dao.CommonuserDao;
import com.akash.daoImpl.AdminDaoImpl;
import com.akash.daoImpl.CommonuserDaoImpl;
import com.akash.models.Student;
import com.akash.models.Teacher;
import com.akash.models.Admin;
import com.akash.models.Commonuser;

@RestController
public class AdminController {
	@Autowired AdminDaoImpl adminDao;
	@Autowired CommonuserDaoImpl commmonuserDao;
	
	
	@GetMapping("/getadmin")
	public Admin getAdmin() {
		return new Admin();
	}

	@GetMapping("/getteacher")
	public Teacher getTeacher() {
		return new Teacher();
	}
	
	@GetMapping("/getstudent")
	public Student getStudent() {
		return new Student();
	}
	
	@RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
	public Admin createAdmin(@RequestBody Admin admin) {
		System.out.println(" User String : "+admin.toString());
		admin.setUser(saveCommonUser(admin.getUser()));
		return adminDao.saveUserAdmin(admin);
	}

	@RequestMapping(value = "/createTeacherAdmin", method = RequestMethod.POST)
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		System.out.println(" Teacher String : "+teacher.toString());
		teacher.setUser(saveCommonUser(teacher.getUser()));
		return adminDao.saveUserTeacher(teacher);
	}
	
	@RequestMapping(value = "/createStudentAdmin", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(" Student String : "+student.toString());
		student.setUser(saveCommonUser(student.getUser()));
		return adminDao.saveUserStudent(student);
	}	
	public Commonuser saveCommonUser(Commonuser commonuser) {
		commonuser.setEnabled(0);
		return commmonuserDao.saveCommonuser(commonuser);
	}
	
	@RequestMapping(value = "/getAllNewUsers",method =RequestMethod.GET )
	public List<Commonuser> getAllNewCommonUsers(){
		return commmonuserDao.findNewlyCreated();
	}
	
	@RequestMapping(value = "/enabeCommonUser",method =RequestMethod.POST )
	public Integer enableCommonUsers(@RequestParam Integer commonId){
		System.out.println("CommonUserId : "+commonId);
	return commmonuserDao.enableCommonuser(commonId);
	//return 100;
	}
	
	
	
}

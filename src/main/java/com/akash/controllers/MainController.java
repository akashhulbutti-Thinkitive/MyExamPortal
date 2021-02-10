package com.akash.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.daoImpl.CommonuserDaoImpl;
import com.akash.models.Commonuser;

@RestController
public class MainController {
	@Autowired CommonuserDaoImpl commuserDao;
	
	@GetMapping("/")
	public String returnLoginPage() {
		//return to login page on server start
		return "login";
	}
	
	@GetMapping("/logout")
	public String successfullogoutPage(HttpSession session) {
		//removing user fromo session after user logs out
		//session.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String returnHomePage(@RequestBody Commonuser username,HttpSession session) {
		//System.out.println("Username: "+username+"   -  Password : ");
		System.out.println(commuserDao.verifyUser(username.getUsername(), username.getPassword()));
		//add user to session if true else return to login
		//Commonuser user = commuserDao.verifyUser(username.getUsername(), username.getPassword());
		//if(user.getEnabled()!=0){
		//		session.setAttribute("user", user);
		//		session.setMaxInactiveInterval(30000);
		//}
		return "home";
	}
	
	@GetMapping("/home")
	public String returnHome(HttpSession session) {
		///Commonuser user = session.getAttribute("user");
		// validate session
		// Home page redirecting
		return "home";
	}
	
	@GetMapping("/forgotPassword")
	public String returnVerifyPage() {
		return "verify";
	}
	
	@PostMapping("/forgotPassword")
	public String isUserAvailable(@RequestParam("question") String question,@RequestParam("answer") String answer) {
		Commonuser user = commuserDao.findByQuestionAndAnswer(question,answer);
		if(user!=null){
			if(user.getEnabled()==1) {
				return "New Password page";
				
			}else {
				return "User is yet to be verified by Admin";
			}
		}
		else {
			return "No User Available";	
		}
		
	}

}

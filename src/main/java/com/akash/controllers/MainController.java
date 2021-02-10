package com.akash.controllers;

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
	public String successfullogoutPage() {
		//removing user fromo session after user logs out
		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String returnHomePage(@RequestBody Commonuser username) {
		//System.out.println("Username: "+username+"   -  Password : ");
		System.out.println(commuserDao.verifyUser(username.getUsername(), username.getPassword()));
		//add user to session if true else return to login
		return "home";
	}
	
	@GetMapping("/home")
	public String returnHome() {
		// Home page redirecting
		return "home";
	}

}

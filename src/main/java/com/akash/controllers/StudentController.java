package com.akash.controllers;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.Path;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.akash.daoImpl.QuestionDaoImpl;
import com.akash.daoImpl.TestDaoImpl;
import com.akash.models.Questions;
import com.akash.models.Test;

@RestController
public class StudentController {

	@Autowired
	TestDaoImpl testDao;
	
	@Autowired QuestionDaoImpl questionDao;

	@RequestMapping(value = "/viewAvailableTest", method = RequestMethod.GET)
	public List getAllAvailableTest() {
		List<Test> list = null;

		return list;
	}

	@RequestMapping(value = "/startTest/{testid}", method = RequestMethod.POST)
	public Questions startTest(@PathVariable("testid") int testid) {
		Questions question = null;
		question = questionDao.getFirstQuestion(testid);
		System.out.println("First Question --> "+question);
		return question;
	}

	@RequestMapping(value = "/nextQuestion/{testid}/{queId}", method = RequestMethod.POST)
	public Questions getNextQuestion(@PathVariable("testid") int testid, @PathVariable("queId") int qid){
		Questions question = null;
		question = questionDao.getNextQuestion(testid, qid);
		System.out.println("Next Question :- "+question);
		return question;
	}

	@RequestMapping(value = "/prevQuestion/{testid}/{queId}", method = RequestMethod.POST)
	public Questions getPreviousQuestion(@PathVariable("testid") int testid, @PathVariable("queId") int qid) {
		Questions question = null;
		question = questionDao.getPrevQuestion(testid, qid);
		System.out.println("Previous Question :- "+question);
		return question;
	}

	@RequestMapping(value = "/submitTest/{testid}", method = RequestMethod.POST)
	public List submitTest(@PathVariable("testid") int testid) {
		List<Test> list = null;

		return list;
	}

	@RequestMapping(value = "/viewResult/{testid}", method = RequestMethod.POST)
	public List getResult(@PathVariable("testid") int testid) {
		List list = null;

		return list;
	}
}

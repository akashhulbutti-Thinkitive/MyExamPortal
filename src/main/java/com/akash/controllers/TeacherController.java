package com.akash.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akash.daoImpl.QuestionDaoImpl;
import com.akash.daoImpl.TeacherDaoImpl;
import com.akash.daoImpl.TestDaoImpl;
import com.akash.models.Questions;
import com.akash.models.Student;
import com.akash.models.Test;

@RestController
public class TeacherController {
	@Autowired TeacherDaoImpl teacherDao;
	@Autowired TestDaoImpl testDao;
	@Autowired QuestionDaoImpl questionDao;
	
	@GetMapping("/getTest")
	public Test getTestObject() {
		return new Test();
	}

	@GetMapping("/getQuestion")
	public Questions getQuestionsObject() {
		return new Questions();
	}
	
	@RequestMapping(value = "/createStudentTeacher", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student  student) {
		System.out.println("Student : "+student);
		return teacherDao.saveStudent(student);
	}
	
	@RequestMapping(value = "/createTestTeacher", method = RequestMethod.POST)
	public Test addStudent(@RequestBody Test test) {
		System.out.println("Student : "+test);
		Test savedtest = testDao.createTest(test);
		System.out.println("Questions : "+savedtest);
		return new Test();
	}
	
	
	@RequestMapping(value = "/addQuestionToTestTeacher/{testId}",method = RequestMethod.POST)
	public Test addQuestionToTest(@PathVariable("testId") int testid ,@RequestBody List<Questions> questionList){
		//System.out.println("test id : "+testid);
		//System.out.println("Questions List : "+questionList);
		Test test = testDao.gettestStatus(testid);
		if(test!=null) {
			List<Questions> availableQuestions = (List<Questions>) test.getQuestions();
			if(availableQuestions.size()>0) {
				availableQuestions.addAll(questionList);
			}else {
				test.setQuestions(questionList);
			}
			test = testDao.updateTest(test);
		}
		
		return test;
	}
	
	@RequestMapping(value = "/getQuestion/{test}/{question}")
	public Questions getSingleQuestion(@PathVariable("test") int testid,@PathVariable("question") int question) {
		//System.out.println("Test : "+testid);
		//System.out.println("Question : "+question);
		Test test = testDao.gettestStatus(testid);
		if(test!=null) {
			
			for(Questions testQueList : test.getQuestions()) {
				if(testQueList.getQid()==question) {
					//System.out.println("test id : "+testQueList.getTest());
//					testQueList.setTest(test.getTestid());
					return testQueList;
				}
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/updateQuestionsTeacher", method = RequestMethod.PUT)
	public Questions updateQuestion(@RequestBody Questions questions) {
	//	System.out.println("Question : "+questions);
		System.out.println("After Save : "+teacherDao.updateQuestions(questions));
		return new Questions();
	}
	
}

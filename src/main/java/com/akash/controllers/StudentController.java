package com.akash.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akash.daoImpl.QuestionDaoImpl;
import com.akash.daoImpl.StudentDaoImpl;
import com.akash.daoImpl.StudentTestResponseDaoImpl;
import com.akash.daoImpl.TestDaoImpl;
import com.akash.models.Commonuser;
import com.akash.models.Questions;
import com.akash.models.Student;
import com.akash.models.StudentTestResponse;
import com.akash.models.Test;

@RestController
public class StudentController {

	@Autowired
	TestDaoImpl testDao;
	@Autowired
	StudentDaoImpl studDao;

	@Autowired
	QuestionDaoImpl questionDao;

	@Autowired
	StudentTestResponseDaoImpl strDao;

	@RequestMapping(value = "/viewAvailableTest", method = RequestMethod.GET)
	public List getAllAvailableTest() {
		List<Test> list = null;

		return list;
	}

	@RequestMapping(value = "/startTest/{testid}", method = RequestMethod.POST)
	public Questions startTest(@PathVariable("testid") int testid, HttpSession session) {
		Questions question = null;
		// Commonuser user = (Commonuser) session.getAttribute("user");
		Student student = studDao.getStudentByUser(2);// (user.getUid());
		List<StudentTestResponse> stResponseList = new ArrayList<>();
		Test testObj = testDao.gettestStatus(testid);// getQuestions();
		List<Questions> questionsList = (List<Questions>) testObj.getQuestions();
		if (questionsList.size() > 0) {
			for (int i = 0; i < testObj.getQuestions().size(); i++) {
				Questions questionTest = questionsList.get(i);
				StudentTestResponse stResponse = new StudentTestResponse();
				stResponse.setRemark("NA");
				stResponse.setAnswers("NA");
				stResponse.setStudent(student);
				stResponse.setTest(testObj);
				stResponse.setQuestion(questionTest);
				strDao.saveStudentTest(stResponse);
			}
		}

		question = questionDao.getFirstQuestion(testid);
		System.out.println("First Question --> " + question);
		return question;
	}

	@RequestMapping(value = "/nextQuestion/{testid}/{queId}", method = RequestMethod.POST)
	public Questions getNextQuestion(@PathVariable("testid") int testid, @PathVariable("queId") int qid) {
		Questions question = null;
		question = questionDao.getNextQuestion(testid, qid);
		System.out.println("Next Question :- " + question);
		return question;
	}

	@RequestMapping(value = "/prevQuestion/{testid}/{queId}", method = RequestMethod.POST)
	public Questions getPreviousQuestion(@PathVariable("testid") int testid, @PathVariable("queId") int qid) {
		Questions question = null;
		question = questionDao.getPrevQuestion(testid, qid);
		System.out.println("Previous Question :- " + question);
		return question;
	}

	@RequestMapping(value = "/submitTest/{testid}", method = RequestMethod.POST)
	public int submitTest(@PathVariable("testid") int testid) {
		
//		Commonuser user = (Commonuser) session.getAttribute("user");
		Student student = studDao.getStudentByUser(2);// (user.getUid());
		//strDao.submitAlltestQuestions(testid, student.getSid());
		List<StudentTestResponse> list = strDao.getAllStudenttestResponses(testid, student.getSid());
		for(StudentTestResponse str : list) {
			str.setRemark("SUBMITTED");
		}
		int size = strDao.saveUpdatedList(list).size();
		return size;
	}

	@RequestMapping(value = "/viewResult/{testid}", method = RequestMethod.POST)
	public List getResult(@PathVariable("testid") int testid) {
//		Commonuser user = (Commonuser) session.getAttribute("user");
		Student student = studDao.getStudentByUser(2);// (user.getUid());
		List<StudentTestResponse> list = strDao.getAllStudenttestResponses(testid, student.getSid());
		
		return null;
	}
}

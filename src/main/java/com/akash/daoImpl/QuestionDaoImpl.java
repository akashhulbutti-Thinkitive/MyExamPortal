package com.akash.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.QuestionDao;
import com.akash.models.Questions;
import com.akash.repository.QuestionRepository;

@Service
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	QuestionRepository questionRepo;

	@Override
	public Questions saveQuestions(Questions question) {
		Questions savedQuestion = questionRepo.save(question);
		return savedQuestion;
	}
	
	@Override
	public Questions updateQuestions(Questions question) {
		Questions updatedQuestion = questionRepo.save(question);
		return updatedQuestion;
	}
	
	public Questions getFirstQuestion(Integer testid) {
		return questionRepo.findFirstQuestion(testid);
	}
	
	public Questions getSingleQuestion(int testid,int questionId) {
		return questionRepo.findByIdAndTest(testid,questionId);
	}
	
	public Questions getNextQuestion(int testid,int questionId) {
		return questionRepo.getNextQuestion(testid,questionId);
	}
	
	public Questions getPrevQuestion(int testid,int questionId) {
		return questionRepo.getPrevQuestion(testid,questionId);
	}

}

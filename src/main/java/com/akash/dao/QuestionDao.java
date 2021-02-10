package com.akash.dao;

import com.akash.models.Questions;

public interface QuestionDao {
	
	public Questions saveQuestions(Questions question);
	
	public Questions updateQuestions(Questions question);

}

package com.akash.dao;

import com.akash.models.Questions;
import com.akash.models.Student;

public interface TeacherDao {
	
	public Student saveStudent(Student student);
	
	public Questions addQuestion(Questions question);
	
	public Questions updateQuestions(Questions questions);

}

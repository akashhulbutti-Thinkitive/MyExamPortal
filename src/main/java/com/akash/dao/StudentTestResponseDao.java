package com.akash.dao;

import java.util.List;

import com.akash.models.StudentTestResponse;

public interface StudentTestResponseDao {
	
	public StudentTestResponse saveStudentTest(StudentTestResponse stResonse);
	
	public StudentTestResponse updateStudentTest(StudentTestResponse stResponse);
	
	public String getSelectedAnswer(Integer questionId,Integer studentid);
	
	public Integer submitAlltestQuestions(Integer testid,Integer studentId);
	
	public List<StudentTestResponse> getAllStudenttestResponses(Integer testid,Integer studentId);

}

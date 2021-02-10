package com.akash.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.StudentTestResponseDao;
import com.akash.models.StudentTestResponse;
import com.akash.repository.StudentTestRespnseRepository;

@Service
public class StudentTestResponseDaoImpl implements StudentTestResponseDao{
	@Autowired StudentTestRespnseRepository strRepo;

	@Override
	public StudentTestResponse saveStudentTest(StudentTestResponse stResonse) {
		return strRepo.save(stResonse);
	}

	@Override
	public StudentTestResponse updateStudentTest(StudentTestResponse stResponse) {
		return null;
	}

	@Override
	public String getSelectedAnswer(Integer questionId, Integer studentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer submitAlltestQuestions(Integer testid, Integer studentId) {
		// TODO Auto-generated method stub
		return strRepo.submitStudentTest(testid,studentId);
	}

	@Override
	public List<StudentTestResponse> getAllStudenttestResponses(Integer testid, Integer studentId) {
		// TODO Auto-generated method stub
		return strRepo.findByTestAndStudent(testid, studentId);
	}
	
	public List<StudentTestResponse> saveUpdatedList(List<StudentTestResponse> list){
		return strRepo.saveAll(list);
	}

}

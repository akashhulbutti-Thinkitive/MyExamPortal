package com.akash.daoImpl;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.StudentDao;
import com.akash.dao.TeacherDao;
import com.akash.models.Questions;
import com.akash.models.Student;
import com.akash.repository.QuestionRepository;
import com.akash.repository.StudentRepository;
import com.akash.repository.TeacherRepository;

@Service
public class TeacherDaoImpl implements TeacherDao{
	
	@Autowired TeacherRepository teacherRepo;
	@Autowired StudentRepository studentRepository;
	@Autowired QuestionRepository questionRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Questions addQuestion(Questions question) {
		Questions savedQuestion = questionRepository.save(question);
		return savedQuestion;
	}

	@Override
	public Questions updateQuestions(Questions questions) {
		Questions updatedQuestion = questionRepository.save(questions);
		return updatedQuestion;
	}

	
	
}

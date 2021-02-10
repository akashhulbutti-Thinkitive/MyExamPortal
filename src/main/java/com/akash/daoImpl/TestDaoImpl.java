package com.akash.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.TestDao;
import com.akash.models.Test;
import com.akash.repository.TestRepository;

@Service
public class TestDaoImpl implements TestDao{

	@Autowired TestRepository testRepo;
	
	@Override
	public Test createTest(Test test) {
		Test savedTest = testRepo.save(test);
		return savedTest;
	}
	
	public Test gettestStatus(int testid) {
		Test tes = testRepo.checkQuestion(testid);
	//	System.out.println(tes);
		if(tes.getTestid()==testid)
			return tes;
		return null;
	}
	
	public Test updateTest(Test test) {
		return testRepo.save(test);
	}

}

package com.akash.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.dao.CommonuserDao;
import com.akash.models.Commonuser;
import com.akash.repository.CommonuserRepository;

@Service
public class CommonuserDaoImpl implements CommonuserDao{
	
	@Autowired CommonuserRepository commonuserRepo;

	@Override
	public Commonuser saveCommonuser(Commonuser commonuser) {
		Commonuser savedCommonuser = commonuserRepo.save(commonuser);
		return savedCommonuser;
	}

	@Override
	public boolean verifyUser(String username, String password) {
		Commonuser savedCommonuser = commonuserRepo.findByUsernameAndPassword(username,password);
		System.out.println(savedCommonuser);	
		return true;
	}

	@Override
	public List<Commonuser> findAllByEnabled(Integer enabled) {
		return commonuserRepo.findAllByEnabled(1);
	}

	@Override
	public List<Commonuser> findNewlyCreated() {
		return commonuserRepo.findAllByEnabled(0);
	}

	@Override
	public Integer enableCommonuser(Integer commonuserId) {
		
		return commonuserRepo.enableCommonuser(commonuserId);
	}
	
	@Override
	public Commonuser findByQuestionAndAnswer(String question,String answer) {
		return commonuserRepo.findByQuestionAndAnswer(question,answer);
	}

}

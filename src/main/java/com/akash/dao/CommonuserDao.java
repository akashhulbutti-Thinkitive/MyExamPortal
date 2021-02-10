package com.akash.dao;

import java.util.List;

import com.akash.models.Commonuser;

public interface CommonuserDao {
	
	public Commonuser saveCommonuser(Commonuser commonuser);
	
	public boolean verifyUser(String username,String password);
	
	public List<Commonuser> findAllByEnabled(Integer enabled);

	public List<Commonuser> findNewlyCreated();
	
	public Integer enableCommonuser(Integer commonuserId);
}

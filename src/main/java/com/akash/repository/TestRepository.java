package com.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akash.models.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{
	
	//@Query(value = "select case when (count(*) >0) then 'true' else 'false' end from dual where exists(select * from test where testid =?1 and status='open')",nativeQuery = true)
	//public Boolean checkQuestion(Integer testid);

	@Query(value = "select * from test where testid =?1 and status='open'",nativeQuery = true)
	public Test checkQuestion(Integer testid);
	
}

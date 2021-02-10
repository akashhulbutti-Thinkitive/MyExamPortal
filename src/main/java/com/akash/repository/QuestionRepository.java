package com.akash.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.models.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{

	@Query(value="SELECT q FROM Questions q WHERE q.test=?1 AND q.qid=?2 ")
	public Questions findByIdAndTest(@Param("test") int test,@Param("qid") int qid);
	
	@Query(value="SELECT * FROM questions q WHERE q.test=?1 AND q.qid>?2  LIMIT 1 ",nativeQuery=true)
	public Questions getNextQuestion(@Param("test") Integer test,@Param("qid") Integer qid);
	
	@Query(value="SELECT * FROM questions q WHERE q.test=?1 AND q.qid<?2  LIMIT 1 ",nativeQuery=true)
	public Questions getPrevQuestion(@Param("test") Integer test,@Param("qid") Integer qid);
	
	@Query(value="SELECT * FROM questions q WHERE q.test=?1  LIMIT 1 ",nativeQuery=true)
	public Questions findFirstQuestion(@Param("test") Integer test);

}

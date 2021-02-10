package com.akash.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.models.StudentTestResponse;

@Repository
public interface StudentTestRespnseRepository extends JpaRepository<StudentTestResponse, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "update student_test_response set answers=:answers,remark=:remark where qid=:qid and student=:student",nativeQuery = true)
	public Integer updateStudentTestAnswer(@Param("student") Integer student,@Param("answers") String answers,@Param("remark")
	String remark,@Param("qid") Integer qid);

	
	@Transactional
	@Modifying
	@Query(value="update student_test_response set remark='submit' where test=:testid and student=:student",nativeQuery=true)
	public Integer submitStudentTest(@Param("testid") Integer testid,@Param("student") Integer student);
	
	@Query(value="select * from student_test_response where test=:?1 and student=:?2",nativeQuery=true)
	public List<StudentTestResponse> findAllBytestAndStudent(@Param("testid") Integer testid,@Param("student") Integer student);
	
	public List<StudentTestResponse> findByTestAndStudent(@Param("test") Integer test,@Param("student") Integer student);
	
	@Query(value="select case when count(*)>0 then true else false end as bool  from student_test_response where test=:?1 and student=:?2",nativeQuery=true)
	public boolean verifyTestForStudent(@Param("testid") Integer testid,@Param("student") Integer student);

}

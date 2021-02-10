package com.akash.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akash.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query(value = "select * from student where user=:userId",nativeQuery = true)
	public Student getStudentByUser(@Param("userId") Integer userId);
	
}

package com.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

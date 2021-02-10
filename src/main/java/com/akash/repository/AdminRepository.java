package com.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}

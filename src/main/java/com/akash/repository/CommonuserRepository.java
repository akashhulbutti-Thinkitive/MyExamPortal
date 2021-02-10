package com.akash.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.models.Commonuser;

@Repository
public interface CommonuserRepository extends JpaRepository<Commonuser, Integer>{

	@Query(value="SELECT * FROM commonuser WHERE username=:username AND password=:password and enabled=1",nativeQuery=true)
	public Commonuser findByUsernameAndPassword(@Param("username") String username,@Param("password") String passowrd);
	
	@Query(value="SELECT * FROM commonuser WHERE enabled=:enabled",nativeQuery=true)
	public List<Commonuser> findAllByEnabled(@Param("enabled") Integer enabled);
	
	@Transactional
	@Modifying
	@Query(value="Update commonuser SET enabled=1 where uid=:uid",nativeQuery=true)
	public int enableCommonuser(@Param("uid") Integer uid);
}

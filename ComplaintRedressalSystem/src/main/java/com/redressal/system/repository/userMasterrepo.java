package com.redressal.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.redressal.system.model.UserTypeMaster;
import com.redressal.system.model.userMaster;

public interface userMasterrepo extends JpaRepository<userMaster, Integer> {

	@Query(value = "SELECT * FROM usermaster WHERE email=? and password = ? and usertype=?", nativeQuery = true)
	 public userMaster getUserByUsernameAndPaswordAndRole(String email, String password, UserTypeMaster usertype);
	
	@Query(value = "SELECT * FROM usermaster WHERE email=? and password = ? ", nativeQuery = true)
	 public userMaster getUserByUsernameAndPasword(String email, String password);
	
	@Query(value = "SELECT * FROM usermaster WHERE pincode=? and usertype = 3 ", nativeQuery = true)
	 public List<userMaster> getEngineerBypin(int pincode);
}

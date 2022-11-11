package com.redressal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redressal.system.model.UserTypeMaster;
import com.redressal.system.repository.UserTypeMasterrepo;

@Service
public class usertypeservice {
	@Autowired
	private UserTypeMasterrepo UtypeRepo;
	
	public UserTypeMaster createuserType(UserTypeMaster utypemaster) {
		 return UtypeRepo.save(utypemaster);
	       
	}
	
	public  List<UserTypeMaster> getAlluserType() {
		return UtypeRepo.findAll();
	       
	}

}

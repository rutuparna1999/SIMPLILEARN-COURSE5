package com.redressal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redressal.system.model.UserTypeMaster;
import com.redressal.system.model.userMaster;
import com.redressal.system.repository.userMasterrepo;



@Service
public class usermasterservice {
	@Autowired
	private userMasterrepo UmasterRepo;
	
	public userMaster authenticateUser(String email, String password, UserTypeMaster usertype) {
		return UmasterRepo.getUserByUsernameAndPaswordAndRole(email, password, usertype);
	}
	
	public userMaster authenticateUsertest(String email, String password) {
		return UmasterRepo.getUserByUsernameAndPasword(email, password);
	}
	
	public userMaster createuser(userMaster umaster) {
		 return UmasterRepo.save(umaster);
	       
	}
	
	public  List<userMaster> getAlluser() {
		return UmasterRepo.findAll();
	       
	}
	public userMaster getusersByID(int id) {
		userMaster userbyid = UmasterRepo.findById(id).get();
		return userbyid;
	}
	public userMaster updatuserbyid(int id, userMaster userbyid) {
        userMaster users= UmasterRepo.findById(id).get();
        users.setFullname(userbyid.getFullname());
        users.setEmail(userbyid.getEmail());
        users.setPassword(userbyid.getPassword());
        users.setAddress(userbyid.getAddress());
        users.setPincode(userbyid.getPincode());
        return UmasterRepo.save(users);
        
    }
	public  List<userMaster> getAllEngineers(int pincode) {
		return UmasterRepo.getEngineerBypin(pincode);
	       
	}
	
	public boolean deleteUserbyId(int id) {
		userMaster users = UmasterRepo.findById(id).get();
		UmasterRepo.delete(users);
        return true;
    }
	
}

package com.redressal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redressal.system.model.ComplainStatus;
import com.redressal.system.model.complainMaster;
import com.redressal.system.model.userMaster;
import com.redressal.system.repository.complainMasterrepo;

@Service
public class complainMasterService {
	@Autowired
	private complainMasterrepo complainrepo;
	
	public complainMaster createComplain(complainMaster complain) {
		 return complainrepo.save(complain);
	       
	}
	public  List<complainMaster> getAllcomplains() {
		return complainrepo.findAll();
	       
	}
	
	public  List<complainMaster> getcomplainsbyuser(int uid) {
		return complainrepo.FindComplainByUser(uid);
	       
	}
	
	public  List<complainMaster> getcomplainsstatusbyuser(int uid) {
		return complainrepo.Findcomplainwithstatusbyuser(uid);
	       
	}
	
	public  List<complainMaster> getcomplainsstatus() {
		return complainrepo.Findcomplainwithstatus();
	       
	}
	
	public complainMaster getComplainsByID(int cid) {
		complainMaster complainbyid = complainrepo.findById(cid).get();
		return complainbyid;
	}
	public complainMaster updatecomplainbyid(int cid, complainMaster complainbyid) {
		complainMaster complains= complainrepo.findById(cid).get();
		//System.out.println("ASSING : " + complainbyid.getAssignto() + "_" + complainbyid.getSolvedby() + "_" + complainbyid.getAssignedby());
		complains.setStatus(complainbyid.getStatus());
        return complainrepo.save(complains);
        
    }
	
}

package com.redressal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redressal.system.model.ComplainStatus;

import com.redressal.system.repository.ComplainStatusrepo;
@Service
public class ComplainStatusService {
	@Autowired
	private ComplainStatusrepo csrepo;
	
	public ComplainStatus createComplainstatus(ComplainStatus status) {
		 return csrepo.save(status);
	       
	}
	public  List<ComplainStatus> getAllstatus() {
		return csrepo.findAll();
	       
	}
	public  List<ComplainStatus> getAllstatusbyengineer(int assignto) {
		return csrepo.Findcomplainbyengineer(assignto);
	       
	}
	
	public  List<ComplainStatus> getAllcomstatusbyengineer(int assignto) {
		return csrepo.Findcomplainstatusbyengineer(assignto);
	       
	}
	public ComplainStatus getStatusByID(int csid) {
		ComplainStatus statusbyid = csrepo.findById(csid).get();
		return statusbyid;
	}
	public ComplainStatus updatestatusbyid(int csid, ComplainStatus statusbyid) {
		ComplainStatus status= csrepo.findById(csid).get();
		//System.out.println("ASSING : " + complainbyid.getAssignto() + "_" + complainbyid.getSolvedby() + "_" + complainbyid.getAssignedby());
		status.setStatus(statusbyid.getStatus());
		status.setRemark(statusbyid.getRemark());
        return csrepo.save(status);
        
    }


}

package com.redressal.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redressal.system.model.feedbackMaster;
import com.redressal.system.repository.feedbackMasterrepo;



@Service
public class feedbackMasterService {
	@Autowired
	private feedbackMasterrepo feedbackrepo;
	
	public feedbackMaster createfeedback(feedbackMaster feedback) {
		 return feedbackrepo.save(feedback);
	       
	}
	public  List<feedbackMaster> getAllfeedbacks() {
		return feedbackrepo.findAll();
	       
	}
	public  List<feedbackMaster> getfeedbackbycid(int cid) {
		return feedbackrepo.FindFeedbackByComplain(cid);
	       
	}
}

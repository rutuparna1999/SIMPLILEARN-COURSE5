package com.redressal.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redressal.system.model.ComplainStatus;
import com.redressal.system.model.UserTypeMaster;
import com.redressal.system.model.complainMaster;
import com.redressal.system.model.feedbackMaster;
import com.redressal.system.model.userMaster;
import com.redressal.system.service.ComplainStatusService;
import com.redressal.system.service.complainMasterService;
import com.redressal.system.service.feedbackMasterService;
import com.redressal.system.service.usermasterservice;
import com.redressal.system.service.usertypeservice;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/")
public class ComplaintRedressalSystemController {
	@Autowired  
	private usertypeservice utypeService;
	@Autowired  
	private usermasterservice userService;
	@Autowired  
	private complainMasterService comService;
	@Autowired  
	private ComplainStatusService csService;
	
	@Autowired  
	private feedbackMasterService feedService;
	
	@GetMapping("/login")
	public userMaster authUser(@RequestParam String email,@RequestParam String password,@RequestParam UserTypeMaster usertype) {
		System.out.println("Login Params : " + email + "_" + password + "_" + usertype);
		
		userMaster user = userService.authenticateUser(email, password,usertype);
		System.out.println("User : " + user.toString());

		return user;
	}
	@GetMapping("/logintest/{email}/{password}")
	public userMaster authUsertest(@PathVariable String email,@PathVariable String password) {
		System.out.println("Login Params : " + email + "_" + password );
		
		userMaster user = userService.authenticateUsertest(email, password);
		System.out.println("User : " + user.toString());

		return user;
	}
	
   //FOR USERTYPE
	@PostMapping("/Usertypes")
    public UserTypeMaster createusertypes( @RequestBody  UserTypeMaster utypemaster) {
        return utypeService.createuserType(utypemaster);
    }
	
	@GetMapping("/Usertypes")
    public List<UserTypeMaster> getusertypes() {
        return  utypeService.getAlluserType();
    }
	
	 //FOR USERMASTER
		@PostMapping("/Users")
	    public userMaster createusers( @RequestBody  userMaster users) {
	        return userService.createuser(users);
	    }
		
		@GetMapping("/Users")
	    public List<userMaster> getusers() {
	        return  userService.getAlluser();
	    }
	    
	    @GetMapping("/Engineers/{pincode}")
	    public List<userMaster> getEngineers(@PathVariable int pincode) {
	        return  userService.getAllEngineers(pincode);
	    } 
	    
	    @GetMapping("/Users/{id}")
	    public ResponseEntity<userMaster> getusersByID(@PathVariable int id) {
	    	userMaster userbyid = null;
	    	userbyid = userService.getusersByID(id);
	        return  ResponseEntity.ok(userbyid);
	    }
    
	    
	    @PutMapping("/Users/{id}")
	    public ResponseEntity<userMaster> updateUsersByid(@PathVariable int id, @RequestBody  userMaster users) {
	    	users = userService.updatuserbyid(id, users);
	        return ResponseEntity.ok(users);
	    }
	 
	 @DeleteMapping("/Users/{id}")
	    public ResponseEntity<Map<String,Boolean>> deleteUserById(@PathVariable int id) {
	        boolean deleted = false;
	        deleted = userService.deleteUserbyId(id);
	        Map<String,Boolean> response = new HashMap<>();
	        response.put("deleted", deleted);
	        return ResponseEntity.ok(response);
	    }
	
		    
		    
		    //COMPLAINMASTER
			 
			@PostMapping("/Complains")
		    public complainMaster createComplain( @RequestBody  complainMaster Complains) {
		        return comService.createComplain(Complains);
		    }
			
			@GetMapping("/Complains")
		    public List<complainMaster> getComplains() {
		        return  comService.getAllcomplains();
		    }
		    
		    @GetMapping("/ComplainsWithStatusByUid/{uid}")
		    public List<complainMaster> getComplainswithstatusbyuid(@PathVariable int uid) {
		        return  comService.getcomplainsstatusbyuser(uid);
		    } 
		    
		    @GetMapping("/ComplainsWithStatus")
		    public List<complainMaster> getComplainswithstatus() {
		        return  comService.getcomplainsstatus();
		    } 
		    @GetMapping("/Complains/{cid}")
		    public ResponseEntity<complainMaster> getComplainsById(@PathVariable int cid) {
		    	complainMaster complainById = null;
		    	complainById = comService.getComplainsByID(cid);
		        return  ResponseEntity.ok(complainById);
		    }
	    
		    
		    @PutMapping("/Complains/{cid}")
		    public ResponseEntity<complainMaster> updatecomplainById(@PathVariable int cid, @RequestBody  complainMaster complains) {
		    	complains = comService.updatecomplainbyid(cid, complains);
		        return ResponseEntity.ok(complains);
		    }
		    
		    @GetMapping("/mycomplains/{uid}")
		    public List<complainMaster> getComplainsbyuid(@PathVariable int uid) {
		        return  comService.getcomplainsbyuser(uid);
		    }
		    
		    //COMPLAINStatus
			 
			@PostMapping("/Status")
		    public ComplainStatus createComplainstatus( @RequestBody  ComplainStatus status) {
		        return csService.createComplainstatus(status);
		    }
			
			@GetMapping("/Status")
		    public List<ComplainStatus> getComplainstatus() {
		        return  csService.getAllstatus();
		    }
			@GetMapping("/Engineerspending/{assignto}")
		    public List<ComplainStatus> getComplainstatusbyengineer(@PathVariable int assignto) {
		        return  csService.getAllstatusbyengineer(assignto);
		    }
			@GetMapping("/EngineerResolved/{assignto}")
		    public List<ComplainStatus> getCompstatusbyengineer(@PathVariable int assignto) {
		        return  csService.getAllcomstatusbyengineer(assignto);
		    }
		    @GetMapping("/Status/{csid}")
		    public ResponseEntity<ComplainStatus> getComplainsStatusById(@PathVariable int csid) {
		    	ComplainStatus status = null;
		    	status = csService.getStatusByID(csid);
		        return  ResponseEntity.ok(status);
		    }
	    
		    
		    @PutMapping("/Status/{csid}")
		    public ResponseEntity<ComplainStatus> updatestatusById(@PathVariable int csid, @RequestBody  ComplainStatus status) {
		    	status = csService.updatestatusbyid(csid, status);
		        return ResponseEntity.ok(status);
		        
		    }
		    
		  //COMPLAINMASTER
			 
			@PostMapping("/feedback")
		    public feedbackMaster createfeedback( @RequestBody  feedbackMaster feedback) {
		        return feedService.createfeedback(feedback);
		    }
			
			@GetMapping("/feedbackbycomplain/{cid}")
		    public List<feedbackMaster> getfeedbackBycid(@PathVariable int cid) {
		    	return feedService.getfeedbackbycid(cid);
		    }
		    
		    @GetMapping("/feedback")
		    public List<feedbackMaster> getfeedback() {
		        return  feedService.getAllfeedbacks();
		    }
		    
}

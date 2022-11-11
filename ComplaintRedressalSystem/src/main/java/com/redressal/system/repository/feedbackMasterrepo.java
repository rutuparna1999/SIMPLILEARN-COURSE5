package com.redressal.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redressal.system.model.feedbackMaster;

public interface feedbackMasterrepo extends JpaRepository<feedbackMaster, Integer> {
	@Query(value = "SELECT * FROM feedbackmaster WHERE cid=?", nativeQuery = true)
	 public List<feedbackMaster> FindFeedbackByComplain(int cid);
}

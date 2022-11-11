package com.redressal.system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redressal.system.model.ComplainStatus;


public interface ComplainStatusrepo extends JpaRepository<ComplainStatus, Integer> {
	@Query(value = "SELECT *  FROM complainstatus  WHERE assignto = ? AND STATUS IN ('RAISED','PROCESSED')", nativeQuery = true)
	 public List<ComplainStatus> Findcomplainbyengineer(int assignto);
	@Query(value = "SELECT *  FROM complainstatus  WHERE assignto = ? AND STATUS IN ('RESOLVED','CLOSED')", nativeQuery = true)
	 public List<ComplainStatus> Findcomplainstatusbyengineer(int assignto);
}

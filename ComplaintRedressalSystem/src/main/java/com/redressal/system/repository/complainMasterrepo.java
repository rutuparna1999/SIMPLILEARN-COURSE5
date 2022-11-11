package com.redressal.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redressal.system.model.complainMaster;


public interface complainMasterrepo extends JpaRepository<complainMaster, Integer> {
	@Query(value = "SELECT * FROM complainmaster WHERE status IN ('CLOSED','RESOLVED') AND createdby=?", nativeQuery = true)
	 public List<complainMaster> FindComplainByUser(int uid);
	 @Query(value = "SELECT *  FROM complainmaster WHERE  status IN ('RAISED','PROCESSED')AND createdby = ? ", nativeQuery = true)
	 public List<complainMaster> Findcomplainwithstatusbyuser(int uid);

	 @Query(value = "SELECT *  FROM complainmaster WHERE cid NOT IN (SELECT cid  FROM complainstatus)", nativeQuery = true)
	 public List<complainMaster> Findcomplainwithstatus();
}

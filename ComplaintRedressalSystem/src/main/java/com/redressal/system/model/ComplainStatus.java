package com.redressal.system.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "complainstatus")
public class ComplainStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int csid;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cid",nullable = false)
	private complainMaster cid;
	private String status = "RAISED";
	private String remark;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "assignto",nullable = false)
	private userMaster assignto;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "assignedby",nullable = false)
	private userMaster assignedby ;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastupdate = new Date();
}

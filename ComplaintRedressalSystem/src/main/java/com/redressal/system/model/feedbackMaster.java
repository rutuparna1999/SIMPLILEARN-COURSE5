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
@Table(name = "feedbackmaster")
public class feedbackMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cid")
	private complainMaster cid;
	private String feedback;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "givenby")
	private userMaster givenby;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "usertype")
	private UserTypeMaster usertype;
	@Column( columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastupdate = new Date();
}

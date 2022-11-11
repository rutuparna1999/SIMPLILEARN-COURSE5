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
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usermaster")
public class userMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//@Column(nullable = false)
	private String fullname;
	//@Column(nullable = false)
	private String email;
	//@Column(nullable = false)
	private String password;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "usertype")
	private UserTypeMaster usertype;
	//@Column(nullable = false)
	private int pincode;
	private String address;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastupdate = new Date();
}

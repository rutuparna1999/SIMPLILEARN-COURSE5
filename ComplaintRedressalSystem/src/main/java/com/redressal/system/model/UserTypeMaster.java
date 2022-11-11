package com.redressal.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usertypemaster")
public class UserTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int utid;
	@Column(name = "roleName", nullable = false)
	private String roleName;
}

package com.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BranchManager
{
	@Id
	private String managerId;
	private String branchName;
	private String branchCity;
	private Integer branchPinCode;
	private String branchId;
	private String managerName;
	private Integer managerExp;
	
	

}

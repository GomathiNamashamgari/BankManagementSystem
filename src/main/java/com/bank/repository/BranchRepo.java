package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.BranchManager;

public interface BranchRepo extends JpaRepository<BranchManager,String>
{
	public BranchManager findByBranchId(String id);
	public BranchManager findByManagerId(String id);
	public BranchManager findByBranchName(String bname);
	public BranchManager findByManagerName(String mname);
	
}

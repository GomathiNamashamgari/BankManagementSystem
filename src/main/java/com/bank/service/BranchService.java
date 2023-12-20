package com.bank.service;

import java.util.List;

import com.bank.model.BranchManager;

public interface BranchService 
{
	public BranchManager getBranchDetails(String id);
	public List<BranchManager> getAllBranchDetails();
	public String insertBranchManager(BranchManager bm);
	public String updateBranchManager(BranchManager bm);
	public String deleteBranchManager(String id);
	public BranchManager getByBranchId(String id);
	public BranchManager getByManagerId(String id);
	public BranchManager getByBranchName(String bname);
	public BranchManager getByManagerName(String mname);
}
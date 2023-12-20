package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.BranchManager;
import com.bank.repository.BranchRepo;

@Service
public class BranchServiceImpl implements BranchService
{
	@Autowired
	BranchRepo brepo;
	
	public BranchServiceImpl(BranchRepo brepo) {
		super();
		this.brepo = brepo;
	}

	@Override
	public BranchManager getBranchDetails(String id) {
		Optional<BranchManager> bm=brepo.findById(id);
		BranchManager b=bm.get();
		return b;
	}

	@Override
	public List<BranchManager> getAllBranchDetails() {
		List<BranchManager> list=brepo.findAll();
		return list;
	}

	@Override
	public String insertBranchManager(BranchManager bm) {
		brepo.save(bm);
		return "One record has been inserted into BranchManager relation : ";
	}

	@Override
	public String updateBranchManager(BranchManager bm) {
		brepo.save(bm);
		return "One record has been updated into BranchManager relation : ";
	}

	@Override
	public String deleteBranchManager(String id) {
		brepo.deleteById(id);
		return "One record has been deleted..!";
	}

	@Override
	public BranchManager getByBranchId(String id) {
		BranchManager b=brepo.findByBranchId(id);
		return b;
	}

	@Override
	public BranchManager getByManagerId(String id) {
		BranchManager b = brepo.findByManagerId(id);
		return b;
	}

	@Override
	public BranchManager getByBranchName(String bname) {
		BranchManager b = brepo.findByBranchName(bname);
		return b;
	}

	@Override
	public BranchManager getByManagerName(String mname) {
		BranchManager b = brepo.findByManagerName(mname);
		return b;
	}

	
	
}
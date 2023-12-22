package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.BranchManager;
import com.bank.service.BranchService;


@RestController
@RequestMapping("/branch")
public class BranchController
{
	@Autowired 
	BranchService bservice;

	public BranchController(BranchService bservice) {
		super();
		this.bservice = bservice;
	}
	//fetching all  bank details
	@GetMapping("/getdetails")
	public ResponseEntity<List<BranchManager>> getAllBranchDetails()
	{
		List<BranchManager> list = bservice.getAllBranchDetails();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//Fetching details by using id
	@GetMapping("/getalldetails/{id}")
	public ResponseEntity<BranchManager> get(@PathVariable("id") String id)
	{
		BranchManager bm = bservice.getBranchDetails(id);
		return new ResponseEntity<>(bm,HttpStatus.OK);
	}
	//insert records
	@PostMapping("/insertdetails")
	public ResponseEntity<String> insert(@RequestBody BranchManager bm)
	{
		String s = bservice.insertBranchManager(bm);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//update records
	@PutMapping("/updatedetails/{id}")
	public ResponseEntity<String> update(@PathVariable("id")String id,@RequestBody BranchManager bm)
	{
		String s = bservice.updateBranchManager(bm);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//delete records
	@DeleteMapping("/deletedetails/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")String id)
	{
		String s = bservice.deleteBranchManager(id);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//To retrieve the details by using branchid
	@GetMapping("/getbdeatails/{id}")
	public ResponseEntity <BranchManager>getbid(@PathVariable("id") String id)
	{
		BranchManager bm = bservice.getByBranchId(id);
		return new ResponseEntity<>(bm,HttpStatus.OK);
	}
	@GetMapping("/getmdetails/{id}")
	public ResponseEntity <BranchManager>getmid(@PathVariable("id") String id)
	{
		BranchManager bm = bservice.getByManagerId(id);
		return new ResponseEntity<>(bm,HttpStatus.OK);
	}
	@GetMapping("/getdetails/{bname}")
	public ResponseEntity <BranchManager>getbname(@PathVariable("bname") String bname)
	{
		BranchManager bm = bservice.getByBranchName(bname);
		return new ResponseEntity<>(bm,HttpStatus.OK);
	}
	@GetMapping("/getdetails/{mname}")
	public ResponseEntity <BranchManager>getmname(@PathVariable("mname") String mname)
	{
		BranchManager bm = bservice.getByManagerName(mname);
		return new ResponseEntity<>(bm,HttpStatus.OK);
	}
	

}
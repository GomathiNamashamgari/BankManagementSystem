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

import com.bank.service.TransactionService;
import com.bank.model.Transaction;


@RestController
@RequestMapping("/transaction")
public class TransactionController 
{
	@Autowired
	TransactionService tservice;

	public TransactionController(TransactionService tservice) {
		super();
		this.tservice = tservice;
	}
	//fetching the records of account details
	
	@GetMapping("/getdetails")
	public ResponseEntity<List<Transaction>> getTransactionDetails()
	{
		List<Transaction> list = tservice.getTransactionDetails();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//inserting the values into the relation
	@PostMapping("/insertdetails")
	public ResponseEntity<String> insert(@RequestBody Transaction t)
	{
		String s = tservice.insertTransaction(t);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//updation operation
	@PutMapping("/updatedetails/{id}")
	public ResponseEntity<String> update(@PathVariable("id")Integer id,@RequestBody Transaction t)
	{
		String s = tservice.updateTransaction(t);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//deleteing the records by using id
	@DeleteMapping("/deletedetails/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")Integer id)
	{
		String s = tservice.deleteTransaction(id);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//getting the records of particular row based on id
	@GetMapping("/getalldetails/{id}")
	public ResponseEntity<Transaction> get(@PathVariable("id")Integer id)
	{
		Transaction t = tservice.getTransactionDetails(id);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	@GetMapping("/getdetails/{id}")
	public ResponseEntity<Transaction> getaccNumber(@PathVariable("id")Integer id)
	{
		Transaction t = tservice.getByTransactionId(id);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
}



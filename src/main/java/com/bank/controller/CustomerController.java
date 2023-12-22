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

import com.bank.model.Customer;
import com.bank.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	CustomerService cservice;

	public CustomerController(CustomerService cservice) {
		super();
		this.cservice = cservice;
	}
	//retrieving all the details
	@GetMapping("/getallrecords")
	public ResponseEntity<List<Customer>> getCustomerDetails()
	{
		List<Customer> list = cservice.getCustomerDetails();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	//insert records 
	@PostMapping("/insertdetails")
	public ResponseEntity<String> insert(@RequestBody Customer c)
	{
		String s = cservice.insertCustomer(c);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	
	//retrieve records by id
	@GetMapping("/getdetails/{id}")
	public ResponseEntity<Customer> get(@PathVariable("id")String id)
	{
		Customer c = cservice.getCustomerDetails(id);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	//update the records
	@PutMapping("/updatedetails/{id}")
	public ResponseEntity<String> update(@PathVariable("id")String id,@RequestBody Customer c)
	{
		String s = cservice.updateCustomer(c);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
		
	}
	//delete bank record
	@DeleteMapping("/deleterecords/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")String id)
	{
		String s= cservice.deleteCustomer(id);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	//fetching the customer details by using name
	@GetMapping("/getname/{cname}")
	public ResponseEntity<Customer> getcname(@PathVariable("cname") String cname)
	{
		Customer c = cservice.getByCustomerName(cname);	
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	//fetching the customer details by using contact info
	@GetMapping("/getcustcontact/{contact}")
	public ResponseEntity<Customer> getcustcontact(@PathVariable("contact") Long contact)
	{
		Customer c = cservice.getByCustomerContact(contact);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}

	
}
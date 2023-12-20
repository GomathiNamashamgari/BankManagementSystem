package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	TransactionRepo trepo;
	

	public TransactionServiceImpl(TransactionRepo trepo) {
		super();
		this.trepo = trepo;
	}

	@Override
	public Transaction getTransactionDetails(Integer id) {
		Optional<Transaction> t=trepo.findById(id);
		Transaction t1=t.get();
		return t1;
	}

	@Override
	public List<Transaction> getTransactionDetails() {
		List<Transaction> t=trepo.findAll();
		return t;
	}

	@Override
	public String insertTransaction(Transaction t) {
		trepo.save(t);
		return "One record has been inserted into the Transaction Relation";
	}

	@Override
	public String updateTransaction(Transaction t) {
		trepo.save(t);
		return "One record has been updated into the Transaction Relation";
	}

	@Override
	public String deleteTransaction(Integer id) {
		trepo.deleteById(id);
		return "One record has been deleted..!";
	}

	@Override
	public Transaction getByTransactionId(Integer id) {
		Transaction transaction = trepo.findByTransactionId(id);
		return transaction;
	}

	
	
}

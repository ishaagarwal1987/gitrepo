package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Transaction;

public interface TransactionService {
	
	public ResponseEntity<String> addTransaction(String transactionObj, String chequeObj);
	
	public List<Transaction> getTransactions(String user1);
	
	public double getBalance(String user1);

}

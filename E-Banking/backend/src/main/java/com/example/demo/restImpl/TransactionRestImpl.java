package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Transaction;
import com.example.demo.rest.TransactionRest;
import com.example.demo.service.TransactionService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TransactionRestImpl implements TransactionRest{

	@Autowired
	TransactionService transactionService;
	
	@Override
	public ResponseEntity<String> addTransaction(String transactionObj, String chequeObj) {
		
		return transactionService.addTransaction(transactionObj, chequeObj);
	}

	@Override
	public List<Transaction> getTransactions(String user1) {
		
		return transactionService.getTransactions(user1);
	}

	@Override
	public double getBalance(String user1) {
		
		return transactionService.getBalance(user1);
	}

}

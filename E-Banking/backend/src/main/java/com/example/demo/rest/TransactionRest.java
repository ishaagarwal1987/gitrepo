package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Transaction;

@RequestMapping(path="/transaction")
public interface TransactionRest {
	
	@PostMapping
	public ResponseEntity<String> addTransaction(@RequestParam("transaction") String transactionObj,@RequestParam("cheque") String chequeObj);
	
	@GetMapping("/{user}")
	public List<Transaction> getTransactions(@PathVariable("user")String user1);
	
	@GetMapping("/balance/{user}")
	public double getBalance(@PathVariable("user")String user1);

}

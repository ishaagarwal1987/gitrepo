package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Sort;
import com.example.demo.Model.Cheque;
import com.example.demo.Model.Transaction;
import com.example.demo.Model.User;
import com.example.demo.repository.ChequeRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import com.example.demo.Utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	ChequeRepository chequeRepository;
	
	@Override
	public ResponseEntity<String> addTransaction(String transactionObj, String chequeObj) {
		try {
			System.out.println("Transaction obj = " +transactionObj + "\nCheque Obj = "+chequeObj);
			ObjectMapper mapper = new ObjectMapper();
			Transaction transaction = mapper.readValue(transactionObj, Transaction.class);
			//System.out.println("Transaction obj = " +transaction);
			if(!chequeObj.equals("null"))
			{
				ObjectMapper mapper1 = new ObjectMapper();
				Cheque cheque = mapper1.readValue(chequeObj, Cheque.class);
				transaction.setCheque(chequeRepository.save(cheque));
			}
			
			//System.out.println("Transaction = "+transaction);
			transactionRepository.save(transaction);
			
			return Utils.getResponseEntity("Transaction done SuccessFully", HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public List<Transaction> getTransactions(String user1) {
		try {
			
			//Sort sortBy = Sort.by(Sort.Direction.DESC, "timestamp");
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(user1, User.class);
			//System.out.println("User = "+user);
			return transactionRepository.findByUserOrderByTimestampDesc(user);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public double getBalance(String user1) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(user1, User.class);
			System.out.println("Finding balance");
			return transactionRepository.findBalanceOfUser(user);
			
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			return 0;
		}
		
	}

}

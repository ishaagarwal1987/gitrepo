package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Transaction;
import com.example.demo.Model.User;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByUserOrderByTimestampDesc(User user);

	double findBalanceOfUser(User user);

}

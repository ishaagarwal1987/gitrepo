package com.example.demo.Model;


import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
//import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "Transaction.findByUserOrderByTimestampDesc",query = "select t from Transaction t where t.accountno=:user ORDER BY timestamp DESC")
//@NamedNativeQuery(name = "Transaction.findByUserOrderByTimestampDesc" , query = "select * from transaction where user = ? ORDER BY timestamp DESC", resultClass = Transaction.class)
@NamedQuery(name = "Transaction.findBalanceOfUser" , query = "select t.balance from Transaction t where t.accountno=:user ORDER BY timestamp DESC LIMIT 1")

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	
	@ManyToOne
    private User accountno;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;
    private String particulars;
    
    @OneToOne
    private Cheque cheque;
    
    private double debitamount;
    private double creditamount;
    private double balance;
    
}

package com.example.demo.Model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Cheque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chequeid;
    private int chequenumber;
    private String bank;
    private Date chequedate;
    private double amount;
    private String ifsccode;
    
    @ManyToOne
    private User payee;

}

package com.example.demo.Model;


import java.sql.Timestamp;

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
public class ChequebookRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestid;
	
	@ManyToOne
	private User accountno;
	
	private String chequebookstatus;
	private Timestamp requestdate;
	private Timestamp acceptedDate;

}

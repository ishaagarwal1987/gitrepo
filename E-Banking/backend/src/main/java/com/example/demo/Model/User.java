package com.example.demo.Model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "User.findByAccountNoAndPassword",query = "select u from User u where u.accountno=:accountNo and u.password=:password")

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountno;
	private String name;
	private String password;
	private String email;
	private String role;
	private String phoneNo;
	private String address;
	private Date createdon;
    private boolean isactive;
    private boolean permissionGranted;

}

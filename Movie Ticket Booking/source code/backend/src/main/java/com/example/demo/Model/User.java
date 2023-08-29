package com.example.demo.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "User.findBYEmailAndPassword",query = "select u from User u where u.email=:emailId and u.password=:password")

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private String email;
	private String role;
	private String phoneNo;
	

}

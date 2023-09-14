package com.example.demo.Model;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintid;
	
	@ManyToOne
    private User user;
	
    private String complaint;
    
    @ManyToOne
    private User engineerAssigned;
    
    private String status;
    private Timestamp timestamp;
    
    @JsonManagedReference
    @OneToOne(targetEntity = Feedback.class,mappedBy = "complaint")
    private Feedback feedback;
    
    @JsonManagedReference
    @OneToOne(targetEntity = Fieldwork.class,mappedBy = "complaint")
    private Fieldwork fieldwork;
}

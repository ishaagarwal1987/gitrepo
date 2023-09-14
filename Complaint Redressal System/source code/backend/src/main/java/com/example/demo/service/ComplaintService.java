package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Complaint;

public interface ComplaintService {

	public ResponseEntity<String> addComplaint(Complaint complaint);
	
	public List<Complaint> geAllComplaints();
	
	public List<Complaint> getComplaintsByUser(String user);
	
	public ResponseEntity<String> updateComplaint(int id, String complaint);
	
	public List<Complaint> getComplaintsByEngineerAssigned(String engineer);
}

package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Complaint;
import com.example.demo.Model.User;
import com.example.demo.Utils.Utils;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ComplaintServiceImpl implements ComplaintService{

	@Autowired
	ComplaintRepository complaintRepository;
	
	@Override
	public ResponseEntity<String> addComplaint(Complaint complaint) {
		try {
			complaintRepository.save(complaint);
			return Utils.getResponseEntity("Your Ticket has been raised successfully.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Someting Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public List<Complaint> geAllComplaints() {
		try {
			return complaintRepository.findAllDesc();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Complaint> getComplaintsByUser(String user1) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(user1, User.class);
			return complaintRepository.findByUserDESC(user);
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<String> updateComplaint(int id, String complaint) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			Complaint complaintObj = mapper.readValue(complaint, Complaint.class);
			
			System.out.println("Updating Complaint");
			complaintRepository.save(complaintObj);
			return Utils.getResponseEntity("Updated Successfully.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Complaint> getComplaintsByEngineerAssigned(String engineer) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			User engineerObj = mapper.readValue(engineer,User.class);
			return complaintRepository.findByEngineerAssigned(engineerObj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}

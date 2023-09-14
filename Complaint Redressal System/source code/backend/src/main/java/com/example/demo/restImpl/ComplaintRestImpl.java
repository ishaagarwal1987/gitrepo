package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Complaint;
import com.example.demo.rest.ComplaintRest;
import com.example.demo.service.ComplaintService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ComplaintRestImpl implements ComplaintRest{

	@Autowired
	ComplaintService complaintService;
	
	@Override
	public ResponseEntity<String> addComplaint(Complaint complaint) {
		
		return complaintService.addComplaint(complaint);
	}

	@Override
	public List<Complaint> geAllComplaints() {
		
		return complaintService.geAllComplaints();
	}

	@Override
	public List<Complaint> getComplaintsByUser(String user) {
		
		return complaintService.getComplaintsByUser(user);
	}

	@Override
	public ResponseEntity<String> updateComplaint(int id, String complaint) {
		
		return complaintService.updateComplaint(id, complaint);
	}

	@Override
	public List<Complaint> getComplaintsByEngineerAssigned(String engineer) {
		
		return complaintService.getComplaintsByEngineerAssigned(engineer);
	}

}

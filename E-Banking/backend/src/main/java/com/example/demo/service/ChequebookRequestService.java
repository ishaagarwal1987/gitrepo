package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.ChequebookRequest;

public interface ChequebookRequestService {
	
	public ResponseEntity<String> addRequest(ChequebookRequest chequebookRequest);
	
	public List<ChequebookRequest> getAllRequests();
	
	public ResponseEntity<String> updateStatus(int id, ChequebookRequest chequebookRequest);
	
	public List<ChequebookRequest> getPendingRequests();
	
	public List<ChequebookRequest> getRequestsByUser(String user);

}

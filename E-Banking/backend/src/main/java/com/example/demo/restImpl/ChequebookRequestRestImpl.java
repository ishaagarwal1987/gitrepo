package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ChequebookRequest;
import com.example.demo.rest.ChequeBookRequestRest;
import com.example.demo.service.ChequebookRequestService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ChequebookRequestRestImpl implements ChequeBookRequestRest{

	@Autowired
	ChequebookRequestService requestService;
	
	@Override
	public ResponseEntity<String> addRequest(ChequebookRequest chequebookRequest) {
		
		return requestService.addRequest(chequebookRequest);
	}

	@Override
	public List<ChequebookRequest> getAllRequests() {
		
		return requestService.getAllRequests();
	}

	@Override
	public ResponseEntity<String> updateStatus(int id, ChequebookRequest chequebookRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChequebookRequest> getPendingRequests() {
		
		return requestService.getPendingRequests();
	}

	@Override
	public List<ChequebookRequest> getRequestsByUser(String user) {
		
		return requestService.getRequestsByUser(user);
	}

}

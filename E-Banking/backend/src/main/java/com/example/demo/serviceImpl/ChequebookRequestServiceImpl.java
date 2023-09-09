package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChequebookRequest;
import com.example.demo.Model.User;
import com.example.demo.Utils.Utils;
import com.example.demo.repository.ChequebookRequestRepository;
import com.example.demo.service.ChequebookRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChequebookRequestServiceImpl implements ChequebookRequestService{

	@Autowired
	ChequebookRequestRepository reqRepository;
	
	@Override
	public ResponseEntity<String> addRequest(ChequebookRequest chequebookRequest) {
		try {
			
			reqRepository.save(chequebookRequest);
			return Utils.getResponseEntity("Request Sent Successfully.", HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Utils.getResponseEntity("Something Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public List<ChequebookRequest> getAllRequests() {
		
		
		return reqRepository.findAllOrderByRequestdateDesc();
	}

	@Override
	public ResponseEntity<String> updateStatus(int id, ChequebookRequest chequebookRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChequebookRequest> getPendingRequests() {
		
		return reqRepository.findByPendingStatus();
	}

	@Override
	public List<ChequebookRequest> getRequestsByUser(String user) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			User user1 = mapper.readValue(user, User.class);
			return reqRepository.findByAccountno(user1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

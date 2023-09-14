package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Complaint;
import com.example.demo.Model.Feedback;
import com.example.demo.Utils.Utils;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.service.FeedbackService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Override
	public ResponseEntity<String> addFeedback(Feedback feedback) {
		try {
			feedback.getComplaint().setFeedback(feedback);
			feedbackRepository.save(feedback);
			
			return Utils.getResponseEntity("Feedback sent SuccessFully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return Utils.getResponseEntity("Someting Went Wrong.", HttpStatus.INTERNAL_SERVER_ERROR);}
	}

	@Override
	public List<Feedback> geAllFeedbacks() {
		
		return feedbackRepository.findAll() ;
	}

	@Override
	public List<Feedback> getFeedbackByComplaint(String complaint) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Complaint comp = mapper.readValue(complaint, Complaint.class);
			
			return feedbackRepository.findByComplaint(comp);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

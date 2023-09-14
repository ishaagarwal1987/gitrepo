package com.example.demo.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Feedback;
import com.example.demo.rest.FeedbackRest;
import com.example.demo.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class FeedbackRestImpl implements FeedbackRest{

	@Autowired
	FeedbackService feedbackService;
	
	@Override
	public ResponseEntity<String> addFeedback(Feedback feedback) {
		
		return feedbackService.addFeedback(feedback);
	}

	@Override
	public List<Feedback> geAllFeedbacks() {
		
		return feedbackService.geAllFeedbacks();
	}

	@Override
	public List<Feedback> getFeedbackByComplaint(String complaint) {
		
		return feedbackService.getFeedbackByComplaint(complaint);
	}

}

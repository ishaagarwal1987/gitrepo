package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Model.Feedback;

public interface FeedbackService {
	public ResponseEntity<String> addFeedback(Feedback feedback);
	
	public List<Feedback> geAllFeedbacks();
	
	public List<Feedback> getFeedbackByComplaint(String complaint);
}

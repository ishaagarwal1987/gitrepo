package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Model.Feedback;

@RequestMapping(path="/feedbacks")
public interface FeedbackRest {
	
	@PostMapping
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback);
	
	@GetMapping
	public List<Feedback> geAllFeedbacks();
	
	@GetMapping("/complaint/{complaint}")
	public List<Feedback> getFeedbackByComplaint(@PathVariable(value = "complaint") String complaint);

}

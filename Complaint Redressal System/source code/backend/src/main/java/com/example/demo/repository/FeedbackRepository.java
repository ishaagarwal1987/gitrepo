package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Complaint;
import com.example.demo.Model.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	List<Feedback> findByComplaint(Complaint comp);

}

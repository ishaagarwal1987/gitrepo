package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Complaint;
import com.example.demo.Model.User;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	List<Complaint> findByUser(User user);

	@Query("FROM Complaint c where c.user =:user  ORDER BY timestamp DESC")
	List<Complaint> findByUserDESC(User user);

	@Query("FROM Complaint c ORDER BY timestamp DESC")
	List<Complaint> findAllDesc();

	List<Complaint> findByEngineerAssigned(User engineerObj);

}

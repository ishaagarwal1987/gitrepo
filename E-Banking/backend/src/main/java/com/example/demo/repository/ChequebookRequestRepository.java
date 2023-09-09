package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.ChequebookRequest;
import com.example.demo.Model.User;

public interface ChequebookRequestRepository extends JpaRepository<ChequebookRequest, Integer>{

	@Query("FROM ChequebookRequest ORDER BY requestdate DESC")
	List<ChequebookRequest> findAllOrderByRequestdateDesc();

	@Query("FROM ChequebookRequest c where c.chequebookstatus = 'Pending'")
	List<ChequebookRequest> findByPendingStatus();

	List<ChequebookRequest> findByAccountno(User user1);

}

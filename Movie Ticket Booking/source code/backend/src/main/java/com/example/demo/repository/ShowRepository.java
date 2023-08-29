package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Movie;
import com.example.demo.Model.Shows;

public interface ShowRepository extends JpaRepository<Shows, Integer>{

	List<Shows> findByMovieAndShowdate(Movie movieObj, String movieDate);

}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Genres;
import com.example.demo.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{



	List<Movie> findFewMovies();

	List<Movie> findByGenre(Genres genre);

}

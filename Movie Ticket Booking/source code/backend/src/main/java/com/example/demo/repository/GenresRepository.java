package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Genres;


public interface GenresRepository extends JpaRepository<Genres, Integer>{

}

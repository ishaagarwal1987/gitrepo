package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Cheque;

public interface ChequeRepository extends JpaRepository<Cheque, Integer>{

}

package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Footwear;
import com.demo.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

	Iterable<Stock> findByFootwear(Footwear fc);

}

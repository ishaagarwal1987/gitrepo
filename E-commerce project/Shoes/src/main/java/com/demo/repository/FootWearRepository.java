package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Footwear;
import com.demo.entities.FootwearCategory;

public interface FootWearRepository extends CrudRepository<Footwear, Integer>{

	Iterable<Footwear> findByIsMale(String isMale);

	Iterable<Footwear> findByCategory(FootwearCategory footwearCategory);

}

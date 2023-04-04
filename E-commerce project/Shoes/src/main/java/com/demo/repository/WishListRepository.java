package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.User;
import com.demo.entities.WishList;

public interface WishListRepository extends CrudRepository<WishList, Integer>{

	Iterable<WishList> findByUser(User user);

}

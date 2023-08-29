package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cart;

import com.example.demo.Model.User;
import com.example.demo.constants.MedicareConstants;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import com.example.demo.utils.MedicareUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public ResponseEntity<String> addToCart(Cart cart) {
		try {
			//cart.setCartid(null);
			cartRepository.save(cart);
			return MedicareUtils.getResponseEntity("Product Added to Cart SuccessFully.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

	@Override
	public ResponseEntity<String> removeCart(int id) {
		try {
			cartRepository.deleteById(id);
			return MedicareUtils.getResponseEntity("Product Deleted from cart SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> updateCart(Cart cart) {
		try {
			cartRepository.save(cart);
			return MedicareUtils.getResponseEntity("Cart Updated SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}



	@Override
	public List<Cart> getCartByUser(String user) {
		ObjectMapper mapper = new ObjectMapper();
		User user1;
		System.out.println("Sending cart...");
		try {
			user1 = mapper.readValue(user, User.class);
			return cartRepository.findByUser(user1);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.User;

@RequestMapping(path="/users")
public interface UserRest {
	
	@PostMapping
	public User signup(@RequestBody User user);
	
	@PostMapping("/login")
	public User login(@RequestParam("accountNo") String accountNo,@RequestParam("password") String password);
	
	@GetMapping
	public List<User> getUsers();
	
	@GetMapping("/user/{accountno}")
	public User getUserByAccountNo(@PathVariable("accountno")int accountno);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePassword(@PathVariable(value = "id") int id,@RequestBody User user);

	@PutMapping("/authorize/{id}")
	public ResponseEntity<String> updateAuthorization(@PathVariable(value = "id") int id,@RequestBody User user);

}

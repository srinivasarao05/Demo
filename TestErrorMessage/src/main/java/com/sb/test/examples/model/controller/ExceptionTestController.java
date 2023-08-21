package com.sb.test.examples.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.examples.model.ResponseBody.ResponseBody;
import com.sb.test.examples.model.dao.User;
import com.sb.test.examples.model.service.ExceptionTestService;

@RestController
public class ExceptionTestController {

	@Autowired
	private ExceptionTestService service;

	@GetMapping("/getUser/{id}")
	public ResponseEntity<ResponseBody> getUserById(@PathVariable String id) {

		ResponseBody responseBody = new ResponseBody();
		List users = new ArrayList<>();

		User user = service.getUserById(id);

		users.add(user);

		if (user == null) {
			responseBody.setErrorCode(HttpStatus.NOT_FOUND);
			responseBody.setErrorMessage("Not Found");
			return ResponseEntity.notFound().build();
		}
		responseBody.setErrorCode(HttpStatus.OK);
		responseBody.setErrorMessage("Found User with given id");
		responseBody.setUser(users);
		return ResponseEntity.ok().body(responseBody);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<ResponseBody> saveUser(@RequestBody User user) {

		ResponseBody responseBody = new ResponseBody();
		List users = new ArrayList<>();

		User addedUser = service.saveUser(user);
		users.add(addedUser);

		if (addedUser == null) {
			responseBody.setErrorCode(HttpStatus.EXPECTATION_FAILED);
			responseBody.setErrorMessage("EXPECTATION FAILED");
			return ResponseEntity.notFound().build();
		}
		responseBody.setErrorCode(HttpStatus.CREATED);
		responseBody.setErrorMessage("User Created Successfully");
		responseBody.setUser(users);
		return ResponseEntity.ok().body(responseBody);
	}

}

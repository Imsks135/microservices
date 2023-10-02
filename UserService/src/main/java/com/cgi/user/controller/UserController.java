package com.cgi.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cgi.user.model.User;
import com.cgi.user.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<?> getAllUser() {
		List<User> userList = userService.getAllUser();
		ResponseEntity<List<User>> entity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		return entity;
	}

	@PostMapping("/users")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		ResponseEntity<?> entity;
		User createdUser = userService.addUser(user);
		if (createdUser != null) {
			entity = new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<String>("User can not be added - failure.....", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody User user) {
		ResponseEntity<?> entity;
		boolean isValid = userService.validateUser(user);
		if (isValid) {
			// entity = new ResponseEntity<String>("Logged In Successfully...",
			// HttpStatus.OK);
			String token = getToken(user.getUserId());
			entity = new ResponseEntity<String>(token, HttpStatus.OK);

		} else {
			entity = new ResponseEntity<String>("Invalid Username/Password. Login failure.....",
					HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	private String getToken(String userId) {

		String token = Jwts.builder().setSubject(userId).signWith(SignatureAlgorithm.HS256, "CGI-JAVAFULLSTACK-WAVE2")
				.compact();

		return token;
	}

}

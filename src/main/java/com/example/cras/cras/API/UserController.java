package com.example.cras.cras.API;


import com.example.cras.cras.Models.User;
import com.example.cras.cras.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PutMapping(path = "{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		boolean isSuccess = userService.updateEmailAndName(id, user);
		if (!isSuccess)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		return ResponseEntity.status(HttpStatus.OK).body("User updated");
	}


}

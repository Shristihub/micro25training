package com.userinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.model.UserDTO;
import com.userinfo.service.IUserService;

@RestController
@RequestMapping("/user-service/v1")
public class UserController {
	
	@Autowired
	private IUserService userService;

//	http://localhost:8087/user-service/v1/userinfo/register
	@PostMapping("/userinfo/register")
	ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
		String result = userService.registerUser(userDTO);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(result);
		
	}
	
//	http://localhost:8087/user-service/v1/userinfo/register
	@PostMapping("/userinfo/login")
	ResponseEntity<UserDTO> loginUser(@RequestParam String email,@RequestParam String password){
		UserDTO userDTO =  userService.loginUser(email, password);
		return ResponseEntity.ok(userDTO);
	}
	
	@GetMapping("/userinfo/userId/{userId}")
	ResponseEntity<UserDTO> findByUserId(@PathVariable int userId){
		UserDTO userDTO =  userService.findByUserId(userId);
		return ResponseEntity.ok(userDTO);
	}
}










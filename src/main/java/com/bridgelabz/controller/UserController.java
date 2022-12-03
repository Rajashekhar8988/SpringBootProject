package com.bridgelabz.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.model.UserModel;
import com.bridgelabz.service.IUserService;
import com.bridgelabz.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/add")
	public String add(@RequestBody UserDto userDto) {
		userService.add(userDto);
		return "User added successfully";
	}
	
	@GetMapping("/findById/{id}")
	public UserDto findById(@PathVariable int id) {
		UserDto userDto= userService.findById(id);
		return userDto;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		userService.deleteById(id);
		return "Deleted successfully";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id,@RequestBody UserDto userDto) {
		userService.update(id, userDto);
		return "Updated successfully";
	} 
	
	@GetMapping("/findByEmail/{email}")
	public String findByEmail(@PathVariable String email) {
		userService.findByEmail(email);
		return "Data has been retrived successfully";
	}
	
	@GetMapping("/allUsers")
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}
}

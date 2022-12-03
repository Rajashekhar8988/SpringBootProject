package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.model.UserModel;


public interface IUserService {

	void add(UserDto userDto);
	
	UserDto findById(int id);

	void deleteById(int id);

	void findByEmail(String email);
	
	List<UserDto> getAllUsers();
		
	void update(Integer id,UserDto userDto);
	
}

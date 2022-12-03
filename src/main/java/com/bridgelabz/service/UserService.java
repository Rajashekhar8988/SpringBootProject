package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.custom.exception.EmptyInputException;
import com.bridgelabz.dto.UserDto;
import com.bridgelabz.model.UserModel;
import com.bridgelabz.repository.IRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IRepository repo;

	@Autowired
	 private ModelMapper modelMapper;
	
	@Override
	public void add(UserDto userDto) {
	
		UserModel userModel=modelMapper.map(userDto,UserModel.class);
		if(userModel.getUserName().isEmpty()) {
			throw new EmptyInputException("601","Input fields are Empty");
		}
		repo.save(userModel);
	}

	@Override
	public UserDto findById(int id) {
		Optional<UserModel> userModel=repo.findById(id);
		UserDto userDto=modelMapper.map(userModel, UserDto.class); 
		return userDto;
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	@Override
	public void findByEmail(String email) {
		 repo.findByEmail(email);		
	}
	
	@Override
	public void update(Integer id,UserDto userDto) {
		UserModel userModel=modelMapper.map(userDto,UserModel.class);
		UserModel userModel2=repo.getOne(id);
		if(userModel2!=null) {
			userModel2.setUserName(userModel.getUserName());
			repo.save(userModel2);
		}
		else {
			repo.save(userModel);
		}
	}
	
	@Override
	public List<UserDto> getAllUsers() {
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return repo.findAll()
				.stream()
				.map(userDto->
				modelMapper.map(userDto,UserDto.class))
				.collect(Collectors.toList());
	}
	
}

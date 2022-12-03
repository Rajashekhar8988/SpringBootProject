package com.bridgelabz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.model.UserModel;

@Repository
public interface IRepository extends JpaRepository<UserModel, Integer>{
	
	public Optional<UserModel> findByEmail(String email);
		
}

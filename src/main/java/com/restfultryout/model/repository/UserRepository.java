package com.restfultryout.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.restfultryout.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//save
	
	//findUserWithId
	
	//findAllUsers
	
	
	//update usecase
	
	//removeUserWithId
}

package com.techprimer.SwaggerTutorial.repository;

import com.techprimer.SwaggerTutorial.entity.UserEntity;
import com.techprimer.SwaggerTutorial.models.User;

public interface BankRepository {

	public boolean isPresent(User user);
	
	public UserEntity addNewUser(User user);

	public UserEntity findOne(int id);
}

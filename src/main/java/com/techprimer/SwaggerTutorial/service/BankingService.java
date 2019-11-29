package com.techprimer.SwaggerTutorial.service;

import com.techprimer.SwaggerTutorial.entity.UserEntity;
import com.techprimer.SwaggerTutorial.expections.InsufficientAccountBalanceException;
import com.techprimer.SwaggerTutorial.expections.UserAlreadyPresentException;
import com.techprimer.SwaggerTutorial.expections.UserNotFoundException;
import com.techprimer.SwaggerTutorial.models.User;

public interface BankingService {

	public UserEntity createUser(User user) throws UserAlreadyPresentException;

	public UserEntity depositMoney(int id, float amount) throws UserNotFoundException;

	public UserEntity withdrawMoney(int id, float amount)
			throws UserNotFoundException, InsufficientAccountBalanceException;

	public String deactivateAccount(int id) throws UserNotFoundException;
}

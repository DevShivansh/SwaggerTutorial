package com.techprimer.SwaggerTutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimer.SwaggerTutorial.entity.UserEntity;
import com.techprimer.SwaggerTutorial.expections.InsufficientAccountBalanceException;
import com.techprimer.SwaggerTutorial.expections.UserAlreadyPresentException;
import com.techprimer.SwaggerTutorial.expections.UserNotFoundException;
import com.techprimer.SwaggerTutorial.models.User;
import com.techprimer.SwaggerTutorial.repository.BankRepository;

@Service
public class BankingServiceImpl implements BankingService{
	
	@Autowired
	private BankRepository bankRepository;

	@Override
	public UserEntity createUser(User user) throws UserAlreadyPresentException {
		
		if( bankRepository.isPresent(user))
			throw new UserAlreadyPresentException();
		
		return bankRepository.addNewUser(user);
	}

	@Override
	public UserEntity depositMoney(int id, float amount) throws UserNotFoundException{
		UserEntity entity = bankRepository.findOne(id);
		if( entity == null)
			throw new UserNotFoundException();
		
		entity.creditBalence(amount);
		
		return entity;
	}

	@Override
	public UserEntity withdrawMoney(int id, float amount)
			throws UserNotFoundException, InsufficientAccountBalanceException {
		UserEntity entity = bankRepository.findOne(id);
		if( entity == null)
			throw new UserNotFoundException();
		
		entity.debitBalance(amount);
		
		return entity;
	}

	@Override
	public String deactivateAccount(int id) throws UserNotFoundException {
		UserEntity entity = bankRepository.findOne(id);
		if( entity == null)
			throw new UserNotFoundException();
		return entity.deactivate();
	}

}

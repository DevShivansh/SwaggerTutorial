package com.techprimer.SwaggerTutorial.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.techprimer.SwaggerTutorial.entity.UserEntity;
import com.techprimer.SwaggerTutorial.models.User;

@Component
public class InMemoryBankRepository implements BankRepository {
	
	private static List<UserEntity> users;
	
	private static int userCount = 0;
	
	static {
		users = new ArrayList<UserEntity>();
	}
	

	@Override
	public boolean isPresent(User user) {
		if (users.isEmpty())
			return false;

		return !users.stream().filter(obj -> obj.equals(user)).collect(Collectors.toList()).isEmpty();

	}

	@Override
	public UserEntity addNewUser(User user) {
		UserEntity entity = new UserEntity(++userCount, user);
		users.add(entity);
		return entity;
	}

	@Override
	public UserEntity findOne(int id) {
		List<UserEntity> list = users.stream().filter(obj -> obj.equals(id)).collect(Collectors.toList());
		return list.isEmpty() ? null : list.get(0);
	}

	
}

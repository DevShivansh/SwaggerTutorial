package com.techprimer.SwaggerTutorial.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {

	
	@GetMapping(name = "/hello")
	public List<User> getUsers() {
		List<User> list = new ArrayList<UserController.User>( Arrays.asList(new User("user1", 1), new User("user2", 2)));
		return list;
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable final String userName) {
		return new User(userName, 1);
	}
	
	
	
	private class User {
		String userName;
		int id;
		
		public User(String userName, int id) {
			// TODO Auto-generated constructor stub
			this.userName = userName;
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
	}
	
}

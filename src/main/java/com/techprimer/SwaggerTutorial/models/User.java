package com.techprimer.SwaggerTutorial.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private String userName;
	private String email;
	private String password;
	private long number;
	private float balance;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
}

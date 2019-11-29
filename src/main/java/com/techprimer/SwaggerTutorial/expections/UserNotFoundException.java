package com.techprimer.SwaggerTutorial.expections;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User not found in DB");
	}
}

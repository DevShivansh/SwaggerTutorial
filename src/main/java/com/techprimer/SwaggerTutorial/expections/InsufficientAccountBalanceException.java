package com.techprimer.SwaggerTutorial.expections;

public class InsufficientAccountBalanceException extends Exception {

	public InsufficientAccountBalanceException() {
		super("Insufficient account balance, cannot proceed transaction");
	}
}

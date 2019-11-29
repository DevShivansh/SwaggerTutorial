package com.techprimer.SwaggerTutorial.entity;

import com.techprimer.SwaggerTutorial.expections.InsufficientAccountBalanceException;
import com.techprimer.SwaggerTutorial.models.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEntity extends User{

	private int id;
	private boolean isActive;

	
	public UserEntity(int id, User user) {
		super(user.getUserName(), user.getEmail(), user.getPassword(), user.getNumber(), user.getBalance());
		this.id = id;
		this.isActive = true;
	}
	
	public boolean equals(User user) {
		
		if( user.getEmail().equals(getEmail()))
			return true;
		return false;
		
	}
	
	public boolean equals(int id) {
		
		if( this.id == id)
			return true;
		return false;
		
	}

	public void creditBalence(float amount) {
		synchronized (this) {
			setBalance(getBalance() + amount);
		}
	}

	public void debitBalance(float amount) throws InsufficientAccountBalanceException {

		synchronized (this) {
			float balance = getBalance();
			if (balance < amount)
				throw new InsufficientAccountBalanceException();
			else {
				setBalance(balance - amount);
			}
		}
	}

	public String deactivate() {
		if (!isActive) {
			return "Account is already deactivated!";
		}
		isActive = false;
		return "Successfully deactivated Account" + id;
	}
	
}

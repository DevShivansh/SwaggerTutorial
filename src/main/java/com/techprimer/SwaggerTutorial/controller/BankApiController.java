package com.techprimer.SwaggerTutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimer.SwaggerTutorial.entity.ErrorResponse;
import com.techprimer.SwaggerTutorial.entity.UserEntity;
import com.techprimer.SwaggerTutorial.expections.InsufficientAccountBalanceException;
import com.techprimer.SwaggerTutorial.expections.UserAlreadyPresentException;
import com.techprimer.SwaggerTutorial.expections.UserNotFoundException;
import com.techprimer.SwaggerTutorial.models.User;
import com.techprimer.SwaggerTutorial.service.BankingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/operations")
@Api(value = "Bank API", description = "Shows API available from Bank")
public class BankApiController {

	@Autowired
	private BankingService bankingService;

	@ApiOperation(value = "Creates new bank user and return its Entity", response = UserEntity.class)
	@PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createPerson(@RequestBody User user) {

		UserEntity entity = null;
		try {
			entity = bankingService.createUser(user);
		} catch (UserAlreadyPresentException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
	}

	@ApiOperation(value = "Deposit money in user account", response = UserEntity.class)
	@PutMapping(value = "/deposit/{id}/{amount}", produces = "application/json")
	public ResponseEntity<?> deposit(@PathVariable final int id, @PathVariable final float amount) {

		UserEntity entity = null;
		try {
			entity = bankingService.depositMoney(id, amount);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
	}

	@ApiOperation(value = "Withdraw money from user account", response = UserEntity.class)
	@PutMapping(value = "/withdraw/{id}/{amount}", produces = "application/json")
	public ResponseEntity<?> withdraw(@PathVariable final int id, @PathVariable final float amount) {
		UserEntity entity = null;
		try {
			entity = bankingService.withdrawMoney(id, amount);
		} catch (UserNotFoundException | InsufficientAccountBalanceException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
	}

	@ApiOperation(value = "Deactivate user account")
	@PutMapping(value = "/deactivate/{id}", produces = "application/json")
	public ResponseEntity<?> deactivateAccount(@PathVariable final int id) {
		String response;
		try {
			response = bankingService.deactivateAccount(id);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}

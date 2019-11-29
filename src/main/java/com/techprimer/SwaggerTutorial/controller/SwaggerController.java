package com.techprimer.SwaggerTutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api(value ="HelloWorldResource", description = "Shows Hello resource")
public class SwaggerController {
	
	
	@ApiOperation(value = "returns hello world")
	@GetMapping(name = "/hello")
	public String hello() {
		return "Hello";
	}
	
	
	@ApiOperation(value = "returns hello world post")
	@PostMapping(name = "/post")
	public String postHello(@RequestBody final String hello) {
		return "Hello";
	}
	
	@ApiOperation(value = "returns hello world put")
	@PutMapping(name = "/put")
	public String putHello(@RequestBody final String hello) {
		return "Hello";
	}

}

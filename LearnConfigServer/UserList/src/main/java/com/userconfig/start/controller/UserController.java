package com.userconfig.start.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlist")
public class UserController {
	
	@GetMapping("/getAllUser")
	public List<String> getAllUsers(){
		return Stream.of("Jyothi","Prakash","Raj","Gopi").collect(Collectors.toList());
	}

}

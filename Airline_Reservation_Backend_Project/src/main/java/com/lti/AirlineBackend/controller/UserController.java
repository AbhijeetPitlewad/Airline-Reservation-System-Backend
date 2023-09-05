package com.lti.AirlineBackend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.AirlineBackend.entity.User;
import com.lti.AirlineBackend.service.UserServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl UserService;

	
	@GetMapping("/{userEmail}")
	
	public User findUser(@PathVariable("userEmail")String userEmail) throws Exception {
		User user=UserService.findUser(userEmail);
		if(user==null){
            throw new Exception("User not Found");
        }
		return user;
	}
	
	
	
		@PostMapping("/")
		public User addUser(@RequestBody User user)
		{
			return UserService.addUser(user);
		}
		
				
	
		
		
	
		
		
}

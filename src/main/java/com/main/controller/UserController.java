package com.main.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import com.main.model.User;
import com.main.repository.UserRepository;
import com.main.service.UserService;

import jakarta.validation.Valid;

@RestController
@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser =userService.createUser(user);
		return new ResponseEntity<User>(savedUser , HttpStatus.CREATED);
	}
	
	
	

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getEmail(), user.getPassword());

        if (existingUser != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }    
        @PostMapping("/login1")
        public ResponseEntity<HashMap<String, String>> login1(@RequestBody User user) {
            User existingUser = userRepository.findByUsernameAndPassword(user.getEmail(), user.getPassword());
        	HashMap<String, String> res=new HashMap<>();

            if (existingUser != null) {
            	res.put("msg", "Login successful");
            	String sessionId = UUID.randomUUID().toString();
            	res.put("sessionId", sessionId);
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
            	res.put("msg", "Login failed");
                return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
            }
    }

	
//	 @PostMapping("/login")
//	    public ResponseEntity<String> login(@RequestBody User user) {
//	        Boolean existingUser = userService.findByUsernameAndPassword(user.getEmail(), user.getPassword());
//
//	        if (existingUser) {
//	            return new ResponseEntity<>("Login successful", HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
//	        }
//	    }

	 	
	
}

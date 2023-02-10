package com.main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.main.model.User;
import com.main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		
		return userRepository.save(user);
	}
	
	
	//private UserRepository userRepository;
	 //@Autowired
//	  public Boolean findByUsernameAndPassword(String username, String password) {
//		
//		 userRepository.findById(null);
//		 
//		  	  
//	    if(username.equals("abc@gmail.com") && password.equals("abc@gmail.com"))
//	    	return true;
//	    else
//	    	return false;
//	    	
//	  }
	  
	  
	  
	  //private UserRepository userRepository;

	  public User findByUsernameAndPassword(String username, String password) {
	    return userRepository.findByUsernameAndPassword(username, password);
	  }
	  
	  	  

}

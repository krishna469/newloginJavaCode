package com.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	//User findByUsernameAndPassword(String email, String password);
@Autowired	
User findByUsernameAndPassword(String username, String password);
	 
}

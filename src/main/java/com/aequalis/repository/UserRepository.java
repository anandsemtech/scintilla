/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.User;
import java.lang.String;

/**
 * @author leoanbarasanm
 *
 */
public interface UserRepository extends JpaRepository<User, Long>  {
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUserid(Long userid);
	
	User findByUsername(String username);
}

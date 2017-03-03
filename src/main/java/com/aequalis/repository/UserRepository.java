/**
 * 
 */
package com.aequalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aequalis.model.User;
import java.lang.String;
import com.aequalis.model.Type;
import java.util.List;

/**
 * @author leoanbarasanm
 *
 */
public interface UserRepository extends JpaRepository<User, Long>  {
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUserid(Long userid);
	
	User findByUsername(String username);
	
	List<User> findByType(Type type);
	

}

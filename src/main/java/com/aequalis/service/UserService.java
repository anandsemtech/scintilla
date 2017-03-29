/**
 * 
 */
package com.aequalis.service;

import java.util.List;

import com.aequalis.model.Type;
import com.aequalis.model.User;
import com.aequalis.model.Vendor;

/**
 * @author leoanbarasanm
 *
 */
public interface UserService {
	public void addUser(User user);
	
	public User loginUser(String username, String password);
	
	public User findByUserid(Long userid);
	
	public User findByUsername(String username);
	
	public List<User> findByType(Type type);
	
	public 	List<User> findAll();
	
	public List<User> findByVendor(Vendor vendor);
}

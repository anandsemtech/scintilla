/**
 * 
 */
package com.aequalis.service;

import com.aequalis.model.User;

/**
 * @author leoanbarasanm
 *
 */
public interface UserService {
	public void addUser(User user);
	
	public User loginUser(String username, String password);
	
	public User findByUserid(Long userid);
	
	public User findByUsername(String username);
}

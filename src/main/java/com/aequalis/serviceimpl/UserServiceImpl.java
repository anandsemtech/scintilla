/**
 * 
 */
package com.aequalis.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aequalis.model.User;
import com.aequalis.repository.UserRepository;
import com.aequalis.service.UserService;

/**
 * @author leoanbarasanm
 *
 */
@Service
@Qualifier("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public User loginUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findByUserid(Long userid) {
		return userRepository.findByUserid(userid);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}

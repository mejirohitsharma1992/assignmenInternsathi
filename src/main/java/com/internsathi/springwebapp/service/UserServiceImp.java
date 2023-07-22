package com.internsathi.springwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.internsathi.springwebapp.model.User;
import com.internsathi.springwebapp.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}

}

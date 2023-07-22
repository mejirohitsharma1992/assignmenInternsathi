package com.internsathi.springwebapp.service;

import com.internsathi.springwebapp.model.User;

public interface UserService {

	public User createUser(User user);

	public boolean checkEmail(String email);
}

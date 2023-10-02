package com.cgi.user.service;

import java.util.List;
import com.cgi.user.model.User;

public interface UserService {

	public User addUser(User user);

	public boolean validateUser(User user);

	public List<User> getAllUser();

}

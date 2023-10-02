package com.cgi.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgi.user.model.User;
import com.cgi.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(user.getUserId());
		User createdUser = null;
		if (optional.isEmpty()) {

			createdUser = userRepository.save(user);
		}
		return createdUser;
	}

	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		boolean isValid = optional.isPresent() ? true : false;
		return isValid;

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();

	}

}

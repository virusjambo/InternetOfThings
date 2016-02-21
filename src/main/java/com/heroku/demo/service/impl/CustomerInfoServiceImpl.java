package com.heroku.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.demo.constants.ErrorCode;
import com.heroku.demo.input.LoginInput;
import com.heroku.demo.model.User;
import com.heroku.demo.output.LoginOutput;
import com.heroku.demo.repository.UserRepository;
import com.heroku.demo.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUser(String user) {
		return userRepository.findByName(user);
	}

	@Override
	public LoginOutput getValidUser(LoginInput input) {
		User user = userRepository.findByNameAndPassword(input.getUsername(), input.getPassword());
		if (user == null) {
			return new LoginOutput(ErrorCode.INVALID_USER);
		}
		return new LoginOutput(user.getId());

	}

}

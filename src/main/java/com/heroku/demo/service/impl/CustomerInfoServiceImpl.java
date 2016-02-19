package com.heroku.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.demo.model.User;
import com.heroku.demo.repository.UserRepository;
import com.heroku.demo.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUser(String user) {
		return userRepository.findByUserName(user);
	}

}

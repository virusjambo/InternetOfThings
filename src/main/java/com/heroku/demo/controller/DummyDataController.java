package com.heroku.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.demo.constants.Status;
import com.heroku.demo.model.DeviceInfo;
import com.heroku.demo.model.User;
import com.heroku.demo.output.ApiOutput;
import com.heroku.demo.repository.DeviceInfoRepository;
import com.heroku.demo.repository.UserRepository;

@RestController
@RequestMapping(value = "/data", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class DummyDataController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DeviceInfoRepository deviceInfoRepository;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ApiOutput getCustomerInfo() {
		User user = new User("Test", "12345", true);
		user = userRepository.save(user);
		deviceInfoRepository.save(new DeviceInfo("127.9.0.1", Status.OFF, "Fan", user.getId(), true));
		deviceInfoRepository.save(new DeviceInfo("127.9.0.2", Status.OFF, "Fan 1", user.getId(), true));
		deviceInfoRepository.save(new DeviceInfo("127.9.0.3", Status.OFF, "Fan 3", user.getId(), true));

		User user1 = new User("Test1", "12345", true);
		user1 = userRepository.save(user1);
		deviceInfoRepository.save(new DeviceInfo("127.9.0.1", Status.OFF, "Fan", user1.getId(), true));
		deviceInfoRepository.save(new DeviceInfo("127.9.0.2", Status.OFF, "Fan 1", user1.getId(), true));
		deviceInfoRepository.save(new DeviceInfo("127.9.0.3", Status.OFF, "Fan 3", user1.getId(), true));
		return new ApiOutput();

	}

}

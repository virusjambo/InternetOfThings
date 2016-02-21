package com.heroku.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.demo.input.LoginInput;
import com.heroku.demo.output.LoginOutput;
import com.heroku.demo.service.CustomerInfoService;

@RestController
@RequestMapping(value = "/authlogin", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class LoginController {
	@Autowired
	CustomerInfoService customerInfoService;
	

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody LoginOutput login(@RequestBody LoginInput loginInput) {
	
		return customerInfoService.getValidUser(loginInput);
	}
}

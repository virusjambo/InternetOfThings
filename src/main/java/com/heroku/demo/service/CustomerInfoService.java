package com.heroku.demo.service;

import com.heroku.demo.input.LoginInput;
import com.heroku.demo.model.User;
import com.heroku.demo.output.LoginOutput;

public interface CustomerInfoService {
    public User getUser(String user);
    public LoginOutput getValidUser(LoginInput input);

}

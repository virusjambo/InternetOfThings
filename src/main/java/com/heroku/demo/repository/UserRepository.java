package com.heroku.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByName(String name);
	public User findByNameAndPassword(String name,String password);

}

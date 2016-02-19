package com.heroku.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "user_info", uniqueConstraints = {
		@UniqueConstraint(name = "user_info_uk1", columnNames = { "user_name" }) })
public class User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name = "user_name", length = 25)
	private String userName;
	@Column(name = "password", length = 10)
	private String password;
	@Column(name = "active")
	private boolean active;

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param active
	 */
	public User( String userName, String password, boolean active) {
		this.userName = userName;
		this.password = password;
		this.active = active;
	}
	public User() {	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}

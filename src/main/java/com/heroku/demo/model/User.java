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
		@UniqueConstraint(name = "user_info_uk1", columnNames = { "name" }) })
public class User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name = "name", length = 25)
	private String name;
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
	public User( String name, String password, boolean active) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

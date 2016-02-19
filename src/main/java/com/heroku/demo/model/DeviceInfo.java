package com.heroku.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.heroku.demo.constants.Status;

@Entity
@Table(name = "device_info", uniqueConstraints = {
		@UniqueConstraint(name = "user_info_uk1", columnNames = { "mac_address" ,"user_id"}) })
public class DeviceInfo {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name = "mac_address", length = 25)
	private String macAddress;
	@Column(name = "status",nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "user_id", length = 50)
	private long userId;
	@Column(name = "active")
	private boolean active;

	/**
	 * 
	 */
	public DeviceInfo() {
	}

	/**
	 * @param id
	 * @param macAddress
	 * @param status
	 * @param name
	 * @param userId
	 * @param active
	 */
	public DeviceInfo(String macAddress, Status status, String name, long userId, boolean active) {
		this.macAddress = macAddress;
		this.status = status;
		this.name = name;
		this.userId = userId;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}

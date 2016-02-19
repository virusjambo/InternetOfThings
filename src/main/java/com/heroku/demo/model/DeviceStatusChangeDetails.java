package com.heroku.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.heroku.demo.constants.DeviceResponseStatus;
import com.heroku.demo.constants.Status;

@Entity
@Table(name = "device_status_change_details")
public class DeviceStatusChangeDetails {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@Column(name = "device_info_id")
	private long deviceInfoId;

	@Column(name = "from_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status fromStatus;

	@Column(name = "to_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status toStatus;

	@Column(name = "device_response", length = 24)
	private String deviceResponse;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	DeviceResponseStatus status = DeviceResponseStatus.PENDING;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getDeviceInfoId() {
		return deviceInfoId;
	}

	public void setDeviceInfoId(long deviceInfoId) {
		this.deviceInfoId = deviceInfoId;
	}

	public Status getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(Status fromStatus) {
		this.fromStatus = fromStatus;
	}

	public Status getToStatus() {
		return toStatus;
	}

	public void setToStatus(Status toStatus) {
		this.toStatus = toStatus;
	}

	public DeviceResponseStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceResponseStatus status) {
		this.status = status;
	}

	public String getDeviceResponse() {
		return deviceResponse;
	}

	public void setDeviceResponse(String deviceResponse) {
		this.deviceResponse = deviceResponse;
	}

}

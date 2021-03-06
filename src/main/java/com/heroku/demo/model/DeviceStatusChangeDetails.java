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

	/**
	 * 
	 */
	public DeviceStatusChangeDetails() {
	}

	@Column(name = "from_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status fromStatus;

	@Column(name = "to_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status toStatus;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	DeviceResponseStatus status = DeviceResponseStatus.PENDING;

	/**
	 * @param deviceInfoId
	 * @param fromStatus
	 * @param toStatus
	 * @param status
	 */
	public DeviceStatusChangeDetails(long deviceInfoId, Status fromStatus, Status toStatus,
			DeviceResponseStatus status) {
		this.deviceInfoId = deviceInfoId;
		this.fromStatus = fromStatus;
		this.toStatus = toStatus;
		this.status = status;
	}

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

	

	

}

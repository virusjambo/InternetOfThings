package com.heroku.demo.service;

import java.util.List;

import com.heroku.demo.constants.Status;
import com.heroku.demo.model.DeviceInfo;
import com.heroku.demo.output.ApiOutput;

public interface DeviceService {
	public List<DeviceInfo> getAllDevicesForUser(String userName);

	public DeviceInfo getDeviceInfo(String macAddreess);

	public ApiOutput updateDeviceStatus(String macAddreess, Status status);

}

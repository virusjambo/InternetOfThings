package com.heroku.demo.output;

import java.util.ArrayList;
import java.util.List;

import com.heroku.demo.model.DeviceInfo;

public class UserDeviceInfoOutput extends ApiOutput {

	private List<DeviceInfo> deviceInfo = new ArrayList<>();

	public List<DeviceInfo> getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(List<DeviceInfo> deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

}

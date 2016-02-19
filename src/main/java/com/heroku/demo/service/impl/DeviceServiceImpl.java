package com.heroku.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.demo.constants.Status;
import com.heroku.demo.model.DeviceInfo;
import com.heroku.demo.model.User;
import com.heroku.demo.repository.DeviceInfoRepository;
import com.heroku.demo.service.CustomerInfoService;
import com.heroku.demo.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	DeviceInfoRepository deviceInfoRepository;
	@Autowired
	CustomerInfoService customerInfoService;

	@Override
	public List<DeviceInfo> getAllDevicesForUser(String userName) {
		User user = customerInfoService.getUser(userName);
		return deviceInfoRepository.findAllByUserId(user.getId());
	}

	@Override
	public DeviceInfo getDeviceInfo(String macAddress) {
		return deviceInfoRepository.findByMacAddress(macAddress);
	}

	@Override
	public boolean updateDeviceStatus(String macAddress, Status status) {
		DeviceInfo deviceInfo= getDeviceInfo( macAddress);
		deviceInfo.setStatus(status);
		
		return false;
	}

}

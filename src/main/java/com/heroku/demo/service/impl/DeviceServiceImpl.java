package com.heroku.demo.service.impl;

import static com.heroku.demo.constants.DeviceResponseStatus.PENDING;
import static com.heroku.demo.constants.DeviceResponseStatus.SENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.demo.constants.DeviceResponseStatus;
import com.heroku.demo.constants.ErrorCode;
import com.heroku.demo.constants.Status;
import com.heroku.demo.model.DeviceInfo;
import com.heroku.demo.model.DeviceStatusChangeDetails;
import com.heroku.demo.model.User;
import com.heroku.demo.output.ApiOutput;
import com.heroku.demo.repository.DeviceInfoRepository;
import com.heroku.demo.repository.DeviceStatusChangeDetailsRepository;
import com.heroku.demo.service.CustomerInfoService;
import com.heroku.demo.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	DeviceInfoRepository deviceInfoRepository;
	@Autowired
	CustomerInfoService customerInfoService;
	@Autowired
	DeviceStatusChangeDetailsRepository changeDetailsRepository;

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
	public ApiOutput updateDeviceStatus(String macAddress, Status status) {
		DeviceInfo deviceInfo = getDeviceInfo(macAddress);

		if (deviceInfo == null) {
			return new ApiOutput(ErrorCode.INVALID_DEVICE);
		}
		List<DeviceStatusChangeDetails> data = changeDetailsRepository
				.findAllByDeviceInfoIdAndToStatusAndStatusOrStatus(deviceInfo.getId(), status, PENDING, SENT);
		if (data.isEmpty()) {
			changeDetailsRepository
					.save(new DeviceStatusChangeDetails(deviceInfo.getId(), deviceInfo.getStatus(), status, PENDING));
		}

		return new ApiOutput();
	}

	@Override
	public DeviceStatusChangeDetails getChangedStatus(String macAddress) {
		DeviceInfo deviceInfo = getDeviceInfo(macAddress);

		if (deviceInfo == null) {
			return null;
		}
		List<DeviceStatusChangeDetails> data = changeDetailsRepository
				.findByDeviceInfoIdAndStatusOrderByIdAsc(deviceInfo.getId(), PENDING);
		if (data.isEmpty()) {
			return null;

		}
		data.get(0).setStatus(DeviceResponseStatus.SENT);
		changeDetailsRepository.save(data.get(0));
		return data.get(0);
	}

	@Override
	public Boolean updateDeviceResponse(String response) {
		if (response != null) {
			String[] split = response.split(",");
			if (split.length == 2) {
				DeviceStatusChangeDetails changeDetails = changeDetailsRepository.findOne(Long.valueOf(split[0]));

				if (split[1].equals("false")) {
					changeDetails.setStatus(DeviceResponseStatus.FAILED);

				} else {
					changeDetails.setStatus(DeviceResponseStatus.RECEIVED);
					DeviceInfo device = deviceInfoRepository.findOne(changeDetails.getDeviceInfoId());
					device.setStatus(changeDetails.getToStatus());
					deviceInfoRepository.save(device);
					return true;
				}

			}

		}
		return false;
	}

}

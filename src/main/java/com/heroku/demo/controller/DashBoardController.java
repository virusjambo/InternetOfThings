package com.heroku.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.demo.input.StatusChangeInput;
import com.heroku.demo.model.DeviceInfo;
import com.heroku.demo.output.ApiOutput;
import com.heroku.demo.output.UserDeviceInfoOutput;
import com.heroku.demo.service.CustomerInfoService;
import com.heroku.demo.service.DeviceService;

@RestController
@RequestMapping(value = "/info", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class DashBoardController {
	@Autowired
	CustomerInfoService customerInfoService;
	@Autowired
	DeviceService deviceService;

	@RequestMapping(value = "/getcustomerinfo", method = RequestMethod.GET)
	public @ResponseBody UserDeviceInfoOutput getCustomerInfo(@RequestParam String userName) {
		UserDeviceInfoOutput deviceInfoOutput = new UserDeviceInfoOutput();
		deviceInfoOutput.setDeviceInfo(deviceService.getAllDevicesForUser(userName));
		return deviceInfoOutput;
	}

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public @ResponseBody ApiOutput changeStatus(@RequestBody StatusChangeInput statusChangeInput) {

		return null;

	}

	@RequestMapping(value = "/getStatus", method = RequestMethod.GET)
	public @ResponseBody DeviceInfo getStatus(@RequestParam String macAddress) {

		return deviceService.getDeviceInfo(macAddress);

	}

	@RequestMapping(value = "/updateResponse", method = RequestMethod.POST)
	public @ResponseBody DeviceInfo updateStatus(@RequestBody StatusChangeInput statusChangeInput) {

		return null;

	}
}

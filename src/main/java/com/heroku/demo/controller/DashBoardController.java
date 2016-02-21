package com.heroku.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.demo.input.StatusChangeInput;
import com.heroku.demo.model.DeviceStatusChangeDetails;
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
		return deviceService.updateDeviceStatus(statusChangeInput.getMacAddress(), statusChangeInput.getToStatus());

	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public @ResponseBody DeviceStatusChangeDetails getStatus(@RequestParam String macAddress) {
     	return deviceService.getChangedStatus(macAddress);
	}
	
    // it should be in this format 1234,true
	@RequestMapping(value = "/update/{response}", method = RequestMethod.POST)
	public @ResponseBody boolean updateDeviceRespinse(@PathVariable("response") String response) {
		return deviceService.updateDeviceResponse(response);

	}
}

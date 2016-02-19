package com.heroku.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.demo.model.DeviceInfo;

@Repository
public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long> {
	public List<DeviceInfo> findAllByUserId(long userId);

	public DeviceInfo findByMacAddress(String macAddress);

}

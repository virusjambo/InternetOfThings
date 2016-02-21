package com.heroku.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.demo.constants.DeviceResponseStatus;
import com.heroku.demo.constants.Status;
import com.heroku.demo.model.DeviceStatusChangeDetails;

@Repository
public interface DeviceStatusChangeDetailsRepository extends JpaRepository<DeviceStatusChangeDetails, Long>{

	List<DeviceStatusChangeDetails> findAllByDeviceInfoIdAndToStatusAndStatusOrStatus(long deviceInfoId,Status toStatus,DeviceResponseStatus status,DeviceResponseStatus status1);
	List<DeviceStatusChangeDetails> findByDeviceInfoIdAndStatusOrderByIdAsc(long deviceInfoId,DeviceResponseStatus status);

}

package com.heroku.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.demo.model.DeviceStatusChangeDetails;

@Repository
public interface DeviceStatusChangeDetailsRepository extends JpaRepository<DeviceStatusChangeDetails, Long>{

}

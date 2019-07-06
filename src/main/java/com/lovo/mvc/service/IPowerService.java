package com.lovo.mvc.service;

import java.util.List;

import com.lovo.mvc.entity.PowerEntity;

public interface IPowerService {
	
	public List<PowerEntity> findPowerByUserId(String userId);
}

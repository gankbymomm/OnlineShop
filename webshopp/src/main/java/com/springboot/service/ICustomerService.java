package com.springboot.service;

import com.springboot.entity.CustomerEntity;

public interface ICustomerService {
	
	CustomerEntity findById(String id);

}

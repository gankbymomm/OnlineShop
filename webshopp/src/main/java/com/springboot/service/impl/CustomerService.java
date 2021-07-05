package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.CustomerEntity;
import com.springboot.repository.CustomerRepository;
import com.springboot.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerEntity findById(String id) {
		CustomerEntity user = customerRepository.findCustomerById(id);
	return user;
	}

}

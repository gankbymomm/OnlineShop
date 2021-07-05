package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.ProductEntity;
import com.springboot.repository.ProductRepository;
import com.springboot.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductEntity findById(long id) {
		ProductEntity list = productRepository.findById(id);
		return list;
	}

	@Override
	public List<ProductEntity> findByCategoryId(Long id) {
		List<ProductEntity> list = productRepository.findCategoryById(id);
		return list;
	}

	@Override
	public ProductEntity save(ProductEntity entity) {
		ProductEntity productEntity = productRepository.save(entity);
		return productEntity;
	}

}

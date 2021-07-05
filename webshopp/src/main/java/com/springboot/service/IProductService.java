package com.springboot.service;

import java.util.List;

import com.springboot.entity.ProductEntity;

public interface IProductService {

	ProductEntity findById(long id);
	List<ProductEntity> findByCategoryId(Long id);
	ProductEntity save(ProductEntity entity);
}

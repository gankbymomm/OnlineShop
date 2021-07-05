package com.springboot.service;

import java.util.List;

import com.springboot.entity.CategoryEntity;
import com.springboot.entity.ProductEntity;

public interface ICategoryService {
	List<CategoryEntity> findAll();
	CategoryEntity findCategoryById(long id);
	List<ProductEntity> findByNameContaining(String keywords);
}

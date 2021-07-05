package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.CategoryEntity;
import com.springboot.entity.ProductEntity;
import com.springboot.repository.CategoryRepository;
import com.springboot.repository.ProductRepository;
import com.springboot.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> findAll() {
		List<CategoryEntity> list = categoryRepository.findAll();
		return list;
	}

	@Override
	public CategoryEntity findCategoryById(long id) {
		CategoryEntity category = categoryRepository.findCategoryById(id);
		return category;
	}

	@Override
	public List<ProductEntity> findByNameContaining(String keywords) {
		List<ProductEntity> list = productRepository.findByNameContaining(keywords);
		return list;
	}

}

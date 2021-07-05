package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	List<ProductEntity> findByNameContaining(String keywords);

	ProductEntity findById(long id);
	
	List<ProductEntity> findCategoryById(Long id);
}

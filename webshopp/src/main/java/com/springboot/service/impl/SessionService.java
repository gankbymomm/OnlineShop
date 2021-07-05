package com.springboot.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.springboot.entity.ProductEntity;
import com.springboot.service.IProductService;

@SessionScope //Name: scopedTarget.sessionService
@Service
public class SessionService {
	
	@Autowired
	private IProductService productService;
	
	Map<Integer, ProductEntity> map = new HashMap<>();
	
	public ProductEntity add(Integer id) {
		ProductEntity product = map.get(id);
		if (product == null) {
			product = productService.findById(id);
			product.setQuantity(1);
			map.put(id, product);
		} else {
			product.setQuantity(product.getQuantity()+1);
		}
		return product;
	}
	
	public void remove(Integer id) {
		map.remove(id);
	}
	public void clear() {
		map.clear();
	}
	
	public void update(Integer id, int quantity) {
		ProductEntity product = map.get(id);
		product.setQuantity(quantity);
		
	}
	
	public int getCount() {
		int count = 0;
		Collection<ProductEntity> product = this.getItems();
		for (ProductEntity productEntity : product) {
			count += productEntity.getQuantity();
		}
		return count;
	}
	
	public double getAmount() {
		double amount = 0;
		Collection<ProductEntity> product = this.getItems();
		for (ProductEntity productEntity : product) {
			amount += productEntity.getUnitPrice()*productEntity.getQuantity()*(1 - productEntity.getDiscount());
		}
		return amount;
	}
	
	public Collection<ProductEntity> getItems() {
		return map.values();
	}
}

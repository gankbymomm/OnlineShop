package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.service.impl.SessionService;

@Controller
public class CartController {

	@Autowired
	private SessionService cart;
	
	@ResponseBody
	@RequestMapping("/cart/add/{id}")
	public Object[] add(@PathVariable("id") Integer id) {
		cart.add(id);
		Object[] item = {cart.getCount(), cart.getAmount()};
		return item;
	}
	
	@GetMapping("/cart/view")
	public String view() {
		cart.getItems();
	return "cart/view";
	}
	
	@ResponseBody
	@GetMapping("/cart/clear")
	public void clear() {
		cart.clear();
	}
	
	@ResponseBody
	@GetMapping("/cart/remove/{id}")
	public Object[] remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		Object[] item = {cart.getCount(), cart.getAmount()};
		return item;
	}
	
	@ResponseBody
	@RequestMapping("/cart/update/{id}/{qty}")
	public Object[] update(@PathVariable("id") Integer id, @PathVariable("qty") Integer qty) {
		cart.update(id, qty);
		Object[] item = {cart.getCount(), cart.getAmount()};
		return item;
	}
}

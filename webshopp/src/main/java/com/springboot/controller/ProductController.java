package com.springboot.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.bean.MailInfo;
import com.springboot.entity.CategoryEntity;
import com.springboot.entity.ProductEntity;
import com.springboot.service.ICategoryService;
import com.springboot.service.IProductService;
import com.springboot.service.impl.CookieService;
import com.springboot.service.impl.MailService;

@Controller
public class ProductController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private CookieService cookies;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/product/list-category/{id}")
	public String listByCategory(Model model, @PathVariable("id") long id) {
		CategoryEntity category = categoryService.findCategoryById(id);
		List<ProductEntity> list = category.getProductEntities();
		model.addAttribute("list", list);
		return "product/list";
	}
	
	@RequestMapping("/product/list-by-keywords")
	public String listCategoryByKeyword(Model model, @RequestParam("keywords") String keywords) {
		List<ProductEntity> list = categoryService.findByNameContaining(keywords);
		model.addAttribute("list", list);
		return "product/list";
	}

	@RequestMapping("/product/detail/{cid}")
	public String listDetailProduct(Model model, @PathVariable("cid") long id) {
		ProductEntity product = productService.findById(id);
		List<ProductEntity> list = productService.findByCategoryId(product.getCategoryEntity().getId());
		
		//Tăng lượt xem (view count)
		product.setViewCount(product.getViewCount()+1);
		productService.save(product);
		
		model.addAttribute("product", product);
		model.addAttribute("list", list);
		return "product/detail";
	}
	@ResponseBody
	@RequestMapping("/product/favorite/{cid}")
	public boolean addToFavorite(Model model, @PathVariable("cid") Integer id) {
		Cookie nghiadeptrai = cookies.read("nghiadeptrai");
		String value = id.toString();
		if (nghiadeptrai != null) {
			value = nghiadeptrai.getValue();
			if (!value.contains(id.toString())) {
				value += ","+id.toString();
			} else {
				return false;
			}
		}
		cookies.create("nghiadeptrai", value, 30);
		return true;
	}
	
	@ResponseBody
	@RequestMapping("/product/mail")
	public boolean sendMailToFriend(Model model, MailInfo info, HttpServletRequest request) {
		info.setSubject("Tin nhắn hệ thống mua hàng online");
		try {
			String id = request.getParameter("id");
			String link = request.getRequestURL().toString().replace("mail", "detail/"+id);
			info.setBody(info.getBody()+"<hr><a href='"+link+"'>Xem chi tiet</a>");
			mailService.send(info);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}

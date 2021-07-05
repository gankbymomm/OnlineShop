package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.entity.CustomerEntity;
import com.springboot.service.ICustomerService;
import com.springboot.service.impl.CookieService;

@Controller
public class AcountController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	@Autowired
	private CookieService cookie;
	
	@Autowired
	private HttpSession session;

	
	@GetMapping("/account/login")
	public String login() {
		return "account/login";
	}
	
	@PostMapping("/account/login")
	public String login(HttpServletRequest request,Model model ,@RequestParam("id") String id,
			@RequestParam("password") String password, 
			@RequestParam(value = "remember", required = false) boolean rm) {
		CustomerEntity user = customerService.findById(id);
		if (user == null) {
			model.addAttribute("message", "Tài khoản không tồn tại");
		} else if (!password.equals(user.getPassword())) {
			model.addAttribute("message", "Mật khẩu sai");
		} else if (!user.isActivated()) {
			model.addAttribute("message", "Chưa kích hoạt tài khoản");
		} else {
			model.addAttribute("message", "Đăng nhập thành công");
			session.setAttribute("user", user);
			if (rm == true) {
				cookie.create("userid", user.getId(), 30);
				cookie.create("password", user.getPassword(), 30);
			} else {
				cookie.delete("userid");
				cookie.delete("password");
			}
		}
		return "account/login";
	}
}

package com.springboot.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
	
	public Map<String , String> getMessage(String message){
		Map<String , String> result = new HashMap<>();
		if (message.equals("login_sucess")) {
			result.put("message", "Đăng nhập thành công");
			result.put("alert", "success");
		} else if (message.equals("acount_not_exist")) {
			result.put("message", "Tài khoản không tồn tại");
			result.put("alert", "danger");
		} else if (message.equals("register_success")) {
			result.put("message", "Đăng ký thành công");
			result.put("alert", "success");
		} else if (message.equals("account_invalid")) {
			result.put("message", "Tài khoản chưa được kích hoạt");
			result.put("alert", "danger");
		}
		return result;
	}

}

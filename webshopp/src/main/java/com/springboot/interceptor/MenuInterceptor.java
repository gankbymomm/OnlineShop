package com.springboot.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springboot.entity.CategoryEntity;
import com.springboot.service.ICategoryService;


@SuppressWarnings("deprecation")
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private ICategoryService categoryService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<CategoryEntity> list = categoryService.findAll();
		request.setAttribute("category", list);
	}

}

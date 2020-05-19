package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		//獲取前端請求參數
		 String name = request.getParameter("name");
		System.out.println("param name -" + name);
		
		//向request傳值
		request.setAttribute("result","hello"+name);
		return "hello/index";
	}
}

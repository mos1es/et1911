package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.獲取參數
		String name = request.getParameter("name");
		
		//2.調用service服務層 暫時不處理
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		
		//向request域傳值 相當於request.setAttribute(k,v)
		mv.addObject("result","hello"+name);
		
		return mv;
		
	}

}

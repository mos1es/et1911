package com.etoak.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.commons.VerifyCode;

@Controller
public class CodeController {
	
	@RequestMapping("/code")
		public void code(HttpServletRequest request,
				HttpServletResponse response)throws Exception {
			//创建 获取表达式结果 放入到Session中
			VerifyCode code = new VerifyCode();
			BufferedImage image = code.createImage();
			request.getSession().setAttribute("code", code.getResult() + "");
			
			//向前端写图片
			response.setHeader("Pragma","no-cache");
			response.setHeader("Cache-Control","no=cache");
			response.setDateHeader("Expires",0);
			response.setContentType("image/jpeg");
			ImageIO.write(image, "JPEG", response.getOutputStream());
			
		}
	}







package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.Dict;
import com.etoak.bean.PageVo;
import com.etoak.exeception.ParamException;
import com.etoak.service.CarService;
import com.etoak.service.DictService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {

	@Autowired
	CarService carservice;

	@Autowired
	DictService dictService;

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}

	@RequestMapping("/level")
	@ResponseBody
	public List<Dict> level(@RequestBody String groupId) {
		List<Dict> list = dictService.queryList(groupId);
		return list;
	}
	
	//跳转到列表页面
	@RequestMapping("/tolist")
	public String toList() {
		
		return "car/list";
	}
	
	
	
	
	@RequestMapping("/add")
	public String add(MultipartFile file, @Valid Car car, BindingResult bindingresult, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("文件名称 - {}", file.getOriginalFilename());
		log.info("param car -{}", car);

		// 先校验Car
		List<ObjectError> allErrors = bindingresult.getAllErrors();
		// 如果校验失败结果集不为空，则取出错误的校验信息
		if (!CollectionUtils.isEmpty(allErrors)) {
			StringBuffer errorBuf = new StringBuffer();
			for (ObjectError error : allErrors) {
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}

			// 把校验的错误信息写到request域，使用请求转发跳转到车辆添加页面
			// request.setAttribute("paramerror", errorBuf.toString());
			// return "forward:/car/toAdd";

			// 抛出ParamException异常，让全局异常处理器去处理
			throw new ParamException(errorBuf.toString());
		}

		String originalFilename = file.getOriginalFilename();

		// 新文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFilename = uuid + "-" + originalFilename;
		//
		// 目标文件d:/upload/uuid/_老文件名。jpg
		File destFile = new File("d:/upload", newFilename);

		file.transferTo(destFile);

		car.setPic("/pic/" + newFilename);

		// diayong
		carservice.addCar(car);

		return "redirect:/car/toAdd";

	}
	
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(
			@RequestParam(required = false,defaultValue="1") int pageNum,
			@RequestParam(required = false,defaultValue="1") int pageSize,CarVo carVo){
		return carservice.queryList(pageNum, pageSize, carVo);
		
	}
	
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand(){
		return carservice.getAllBrand();
	}
	
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand){
		return carservice.getSeriesbyBrand(brand);
	}
}




















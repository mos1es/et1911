package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.Dict;
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

	@RequestMapping("/add")
	public String add(MultipartFile file, Car car) throws IllegalStateException, IOException {
		log.info("文件名称 - {}", file.getOriginalFilename());
		log.info("param car -{}", car);

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

}

package com.etoak.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {
	//添加车辆
	int addCar(Car car);
	
	//查询车辆列表
	PageVo<CarVo> queryList(int pageNum,int pageSize,CarVo carVo);
	
	//获取所有品牌
		List<String> getAllBrand();
		
		//根据品牌查询车系 品牌可能为空 当品牌为空时
		List<String> getSeriesbyBrand(@Param("brand")String brand);
}

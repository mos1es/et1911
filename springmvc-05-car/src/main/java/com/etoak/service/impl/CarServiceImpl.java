package com.etoak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarServiceImpl implements CarService{
		@Autowired
		CarMapper carmapper;
		
		@Override
		public int addCar(Car car) {
			return carmapper.addCar(car);
		}

		@Override
		public PageVo<CarVo> queryList(int pageNum, int pageSize, CarVo carVo) {
			//设置分页条件
			PageHelper.startPage(pageNum,pageSize);
			//查询列表
			List<CarVo> carList = carmapper.queryList(carVo);
			
			//创建pageInfo对象，用于获取分页数据
			PageInfo<CarVo> pageInfo = new PageInfo(carList);
			return new PageVo<CarVo>(
					pageInfo.getPageNum(),
					pageInfo.getPageSize(),
					carList,
					pageInfo.getTotal(),
					pageInfo.getPages(),
					pageInfo.isIsFirstPage(),
					pageInfo.isIsLastPage());
		}
		
	@Override
	public List<String> getAllBrand(){
		return carmapper.getAllBrand();
	}

	@Override
	public List<String> getSeriesbyBrand(String brand) {
		return carmapper.getSeriesbyBrand(brand);
	}
	
}

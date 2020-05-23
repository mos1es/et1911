package com.etoak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;

@Service
public class CarServiceImpl implements CarService{
		@Autowired
		CarMapper carmapper;
		
		@Override
		public int addCar(Car car) {
			return carmapper.addCar(car);
		}
	
}

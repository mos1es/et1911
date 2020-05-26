package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car{

	//级别名称
	private String levelName;
	
	//变速箱名称
	private String gearboxName;
	
	//排量
	private String outputvolume;
	
	//传到Sql中条件      		spring mvc不封装注解JsonIgnore注解的属性
	@JsonIgnore
	private List<Map<String,Integer>> priceMapList;
	
	//接收前端的车龄条件0-1或1-3
	@JsonIgnore
	private String vehicleAge;
	
	@JsonIgnore
	private Integer startYear;
	
	@JsonIgnore
	private Integer endYear;
}

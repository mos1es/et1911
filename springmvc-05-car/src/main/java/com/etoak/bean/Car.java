package com.etoak.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Car {
	  private Integer id;
	  
	  @NotNull(message = "brand not empty")
	  @NotEmpty(message = "brand不能为空")
	  private String brand;
	  
	  @NotNull(message = "series not empty")
	  @NotEmpty(message="车系不能为空")
	  private String series;
	  
	  @NotNull(message = "price not empty")
	  @Min(value=1,message = "价格最小为1")
	  @Max(value=100,message = "最大为100")
	  private Integer price;
	  private String licensingTime;
	  private String level;
	  private String gearbox;
	  private String outputVolume;
	  private Integer mileage;
	  private String location;
	  private String pic;
	  
	  @Size(min=6,max = 12, message = "概述内容该在6到12个字符之间")
	  private String summary;
	  private String createTime;
	 
}

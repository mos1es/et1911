package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Getter
@Setter
@ToString*/

@Data
@NoArgsConstructor
@AllArgsConstructor  //按照参数顺序生成构造方法
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private List<String> hobbyList;
	
	private Map<String,Object> stuMap;

	
}

package com.etoak.service;

import java.util.List;


import com.etoak.bean.Dict;

public interface DictService {
	/*根据groupID查询字典列表*/
	List<Dict> queryList(String groupId);
	

}

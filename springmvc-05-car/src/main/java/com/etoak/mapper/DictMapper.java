package com.etoak.mapper;

import java.util.List;

import com.etoak.bean.Dict;

/*根据groupid查询字典数据库列表*/
public interface DictMapper {
	List<Dict> queryList(String groupId);
	

}

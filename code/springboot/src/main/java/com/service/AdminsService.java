
package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AdminsEntity;
import com.utils.PageUtils;


/**
 * 系统用户
 */
public interface AdminsService extends IService<AdminsEntity> {
 	PageUtils queryPage(Map<String, Object> params);
    
   	List<AdminsEntity> selectListView(Wrapper<AdminsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AdminsEntity> wrapper);
	   	
}
